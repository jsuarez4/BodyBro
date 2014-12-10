package com.example.bodybro;

import java.util.Date;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MuscleGroupActivity extends Activity {
	//this will store all the muscle related buttons
	ImageButton[] muscleButtons;
	//this will store tags to attach to the buttons
	String[] muscleTags = {"Arms", "Back", "Chest", "Legs", "Shoulders","Body Weight"};
	AlertDialog muscleOveruseDialog;
	//these will be used as keys to be able to pull data for each button
	static final String MUSCLE_KEY = "muscleTag";
	//current user
	ParseUser currentUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_muscle_group);
		setTitle("Body Bro");
		
		if (ParseUser.getCurrentUser() != null){
			currentUser = ParseUser.getCurrentUser();
		}
		
		//initialize the array of buttons for muscles
		muscleButtons = new ImageButton[6];
		muscleButtons[0] = (ImageButton) findViewById(R.id.button_arms);
		muscleButtons[1] = (ImageButton) findViewById(R.id.button_back);
		muscleButtons[2] = (ImageButton) findViewById(R.id.button_chest);
		muscleButtons[3] = (ImageButton) findViewById(R.id.button_legs);
		muscleButtons[4] = (ImageButton) findViewById(R.id.button_shoulders);
		muscleButtons[5] = (ImageButton) findViewById(R.id.button_body_weight);
		
		//loop through buttons and do stuff to them
		for(int i = 0; i < muscleButtons.length; i++){
			//tag this current button with its respective tag
			muscleButtons[i].setTag(muscleTags[i]);
			//attach an on click listener to tell it what to do when clicked
			muscleButtons[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//the muscle group
					final String muscle = (String) v.getTag();
					
					//check to see if you have worked this muscle group in the last 24 hours
					AlertDialog.Builder builder = new AlertDialog.Builder(MuscleGroupActivity.this);
					builder.setMessage("You have worked out this muscle group in the past 48 hours. It is recommended to avoid this muscle group. Are you sure you want to continue?");
					
					//Yes button
					builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//we intend to open the specific muscle group activity
							Intent intent = new Intent(MuscleGroupActivity.this, SpecificMuscleGroupActivity.class);
							//use the tag as a key to map to a value which happens to be the tag also
							intent.putExtra(MUSCLE_KEY, muscle);
							//start the specific muscle group activity now
							startActivity(intent);
						}
					});
					
					//No button
					builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
					muscleOveruseDialog = builder.create();
					
					//now check to see if muscle was used in last 48 hours
					ParseQuery<ParseObject> query = ParseQuery.getQuery("History");
					query.whereEqualTo("user", currentUser.getUsername());
					query.whereEqualTo("workoutType", muscle);
					query.findInBackground(new FindCallback<ParseObject>() {
						
						@Override
						public void done(List<ParseObject> objects, ParseException e) {
							if (!objects.isEmpty()){
								long workoutTime = objects.get(objects.size() - 1).getCreatedAt().getTime();
								long currentTime = System.currentTimeMillis();
								long difference = currentTime - workoutTime;
								
								//if the difference is less than 48 hours
								if (difference < 172800000){
									muscleOveruseDialog.show();
								} else {
									//if we are here then the difference between the last workout time and now was >48 hours
									//we intend to open the specific muscle group activity
									Intent intent = new Intent(MuscleGroupActivity.this, SpecificMuscleGroupActivity.class);
									//use the tag as a key to map to a value which happens to be the tag also
									intent.putExtra(MUSCLE_KEY, muscle);
									//start the specific muscle group activity now
									startActivity(intent);
								}
							} else {
								//if we reach there, then the list we queried was empty and the user has no previous workouts
								//we intend to open the specific muscle group activity
								Intent intent = new Intent(MuscleGroupActivity.this, SpecificMuscleGroupActivity.class);
								//use the tag as a key to map to a value which happens to be the tag also
								intent.putExtra(MUSCLE_KEY, muscle);
								//start the specific muscle group activity now
								startActivity(intent);
							}
						}
					});
				}
			});
			//initialize create workout button
			ImageButton createWorkoutButton = (ImageButton) findViewById(R.id.button_create_workout);
			createWorkoutButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//TODO: send a tag to the next activity that says if the new workout is random or not
					startActivity(new Intent(MuscleGroupActivity.this, CreateWorkoutActivity.class));
				}
			});
		}
		
		
		
	}
}
