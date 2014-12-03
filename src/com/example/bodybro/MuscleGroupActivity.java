package com.example.bodybro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MuscleGroupActivity extends Activity {
	//this will store all the muscle related buttons
	Button[] muscleButtons;
	//this will store tags to attach to the buttons
	String[] muscleTags = {"Arms", "Back", "Chest", "Legs", "Shoulders"};
	
	//these will be used as keys to be able to pull data for each button
	static final String MUSCLE_KEY = "muscleTag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_muscle_group);
		
		//initialize the array of buttons for muscles
		muscleButtons = new Button[5];
		muscleButtons[0] = (Button) findViewById(R.id.button_arms);
		muscleButtons[1] = (Button) findViewById(R.id.button_back);
		muscleButtons[2] = (Button) findViewById(R.id.button_chest);
		muscleButtons[3] = (Button) findViewById(R.id.button_legs);
		muscleButtons[4] = (Button) findViewById(R.id.button_shoulders);
		
		//loop through buttons and do stuff to them
		for(int i = 0; i < muscleButtons.length; i++){
			//tag this current button with its respective tag
			muscleButtons[i].setTag(muscleTags[i]);
			//attach an on click listener to tell it what to do when clicked
			muscleButtons[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//we intend to open the specific muscle group activity
					Intent intent = new Intent(MuscleGroupActivity.this, SpecificMuscleGroupActivity.class);
					//use the tag as a key to map to a value which happens to be the tag also
					intent.putExtra(MUSCLE_KEY, (String)v.getTag());
					//start the specific muscle group activity now
					startActivity(intent);
				}
			});
			//initialize create workout button
			Button createWorkoutButton = (Button) findViewById(R.id.button_create_workout);
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
