package com.example.bodybro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.w3c.dom.Text;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;

public class SpecificMuscleGroupActivity extends Activity {
	
	 	ParseUser currentUser;

	 	
    	private static final String TAG = CreateWorkoutActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_specific_muscle_group);
		setTitle("Body Bro");
		
		//receive the data attached from MuscleGroupActivity, "Chest", "Arms", etc
		 String muscleLabel = getIntent().getExtras().getString(MuscleGroupActivity.MUSCLE_KEY);

		//update the text box with the muscle label sent from the previous activity
		final TextView activityTitle = (TextView) findViewById(R.id.text_view_specific_group);
		activityTitle.setText(muscleLabel);
		//global
		final TextView ranExercise = (TextView)findViewById(R.id.random_work);
		Button RandoButton =(Button)findViewById(R.id.button_randomize_workout);
		final Random randomGenerator = new Random();
		
        
  
		//pull the current user
		currentUser = ParseUser.getCurrentUser();
        //starting button when clicked  	        
		Button btnSave = (Button) findViewById(R.id.button_history_specific_group);
		btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
    	        //make text from edit text to string 
    	        EditText repsInput = (EditText) findViewById(R.id.edit_text_list_view_create_reps);
    	        EditText weightInput = (EditText) findViewById(R.id.edit_text_list_view_create_weight);
    	      //  String MuscleInput = MuscleName;
    	        //String ExerciseInput= ExerciseSpin.getSelectedItem().toString();
    	        //tostring for push to parse
    	         String WeightInput = repsInput.getText().toString();
    	         String RepsInput  = weightInput.getText().toString();
    	         //intent to back to main menu after published 
				startActivity(new Intent(SpecificMuscleGroupActivity.this, MainActivity.class));
				//push to parse objects
				ParseObject CustomWorkOut = new ParseObject("History");
				CustomWorkOut.put("user",currentUser.getUsername());		
				CustomWorkOut.put("workoutType", activityTitle.getText().toString());
				Log.d(TAG, "workout");   
				CustomWorkOut.put("weight", WeightInput);
				Log.d(TAG, "weight");   
				CustomWorkOut.put("reps", RepsInput);
				Log.d(TAG, "reps");   
				CustomWorkOut.put("exercise", ranExercise.getText().toString());
				Log.d(TAG, "exercise");   
				CustomWorkOut.saveInBackground();
				Log.d(TAG, "SAVE SUCCESSFUL");   
				
			}
		});
		
		
		final ArrayList armArray = new ArrayList() {{
           add("Barbell Bicep Drag Curl");
           add("Barbell Curl");
           add("Dumbbell Alternate Bicep Curl");
           add("Dumbbell Alternate Hammer Curl");
           add("Bench Dip");
           add("Dumbbell Decline Triceps Extension");
            add("Barbell Reverse Curl");
            add("Dumbbell Spider Curl");
            add("Dumbbell Zottman Curl");
            add("EZ Bar Decline Close Grip Skull Crusher");
            add("Dumbbell Standing Triceps Extension");
            add("Dumbbell Tricep Kickbacks");
		}};
		
		final ArrayList legArray = new ArrayList(){{
		add("Barbell Deep Squat");
    	add("Barbell Front Squat");
    	add("Barbell Squat");
    	add("Barbell Zercher Squat");
    	add("Lunge");
    	add("Dumbbell Jumping Squats");
    	add("Seated One Leg Calf Raise");
    	add("Standing Calf Raises");
    	add("Mountain Climbers");
    	add("Kettlebell Goblet Squats");
    	add("Dumbbell Squat");
    	add("Dumbbell Rear Lunge");
    	add("Barbell Split Jump");
		}};
		
		
		
        final ArrayList shoulderArray = new ArrayList(){{
        add("Barbell Incline Shoulder Raise");
        add("Barbell Standing Military Press");
        add("Dumbbell Alternate Seated Arnold Press");
        add("Dumbbell Double Incline Shoulder Raise");
        add("Dumbbell Front Two Raise");
        add("Dumbbell Lying Rear Delt Raise");
        add("Weight Plate Shrugs");
        add("Dumbbell Standing Press");
        add("Dumbbell Shoulder Shrug");
        add("Dumbbell Standing Alternate Front Raise");
        add("Dumbbell Seated Dublin Press");
        add("Dumbbell Seated Side Lateral Raise");
        }};
        


	          final ArrayList chestArray =new ArrayList(){{
	            add("Barbell Bench Press");
	            add("Barbell Decline Bench Press");
	            add("Barbell Incline Bench Press");
	            add("Bench Pushups");
	            add("Barbell Decline Pullover");
	            add("Butterfly");
	            add("Barbell Neck Press");
	            add("Barbell Wide Grip Bench Press");
	            add("Dumbbell Decline Fly");
	            add("Dumbbell Bench Press");
	            add("Dumbbell Decline Press");
	            add("Dumbbell Incline Press");
	          }};
	            
	        	final ArrayList backArray = new ArrayList(){{
	        	add("Barbell Bent Over Row");
	        	add("Barbell Deadlift");
	        	add("Barbell Good Morning");
	        	add("Barbell Lying Cambered Row");
	        	add("Pull Ups");
	        	add("Reverse Grip Lat Pull Down");
	        	add("Dumbbell Bent Over Row");
	        	add("Dumbbell Deadlift");
	        	add("Dumbbell One Arm Row");
	        	add("Gorilla Chin Up with Crunch");
	        	add("Kettlebell One Arm Row");
	        	add("Wide Grip Rear Pull Ups");
	        	add("Wide Grip Lat Pulldowns");
	        	}};
	        	

    	           final ArrayList bodyArray = new ArrayList(){{
    	            add("Breakfast");
    	            add("Crunches");
    	            add("Plank");
    	            add("Close Hand Pushup");
    	            add("Wide Hand Pushup");
    	            add("Handstand Pushups");
    	            add("Close Triceps Pushup");
    	            add("Freehand Jump Squat");
    	            add("1 Leg Pushup");
    	            add("Mountain Climbers");
    	            add("V Ups");
    	            add("Twisting Floor Crunch");
    	            add("Toe Touchers");
    	           }};
    	           
//    	           if (muscleLabel.contentEquals("random workout")){
//		RandoButton.setOnClickListener(new View.OnClickListener() {
//		
//			@Override
//			public void onClick(View v) {
//				
//				CharSequence text = "Not a Work Out";
//    	        Toast.makeText(SpecificMuscleGroupActivity.this, text, Toast.LENGTH_SHORT).show();
//			}
//			});
//		}
    	           
    	           
    	           
    	           if (muscleLabel.contentEquals("Arms")){
		RandoButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				String item = (String) armArray.get(randomGenerator.nextInt(armArray.size()));
				((TextView)findViewById(R.id.random_work)).setText(item);
				
				ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
				query.whereEqualTo("exercise", item);
				query.findInBackground(new FindCallback<ParseObject>() {
					
					@Override
					public void done(List<ParseObject> objects, ParseException e) {
						//now that we have pulled a parseobject we can get the image url
						//to load into the pop up diagram
						String imageUrl = (String) objects.get(0).get("imageLink");
						ImageView iv = (ImageView) findViewById(R.id.image_workout);
						Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
					}
				});
			}
		});
	
	};
    if (muscleLabel.contentEquals("Chest")){
RandoButton.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
	String item = (String)chestArray.get(randomGenerator.nextInt(chestArray.size()));
	((TextView)findViewById(R.id.random_work)).setText(item);
	
	ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
	query.whereEqualTo("exercise", item);
	query.findInBackground(new FindCallback<ParseObject>() {
		
		@Override
		public void done(List<ParseObject> objects, ParseException e) {
			//now that we have pulled a parseobject we can get the image url
			//to load into the pop up diagram
			String imageUrl = (String) objects.get(0).get("imageLink");
			ImageView iv = (ImageView) findViewById(R.id.image_workout);
			Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
		}
	});
}
});

};
if (muscleLabel.contentEquals("Back")){
RandoButton.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
String item = (String) backArray.get(randomGenerator.nextInt(backArray.size()));
((TextView)findViewById(R.id.random_work)).setText(item);

ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
query.whereEqualTo("exercise", item);
query.findInBackground(new FindCallback<ParseObject>() {
	
	@Override
	public void done(List<ParseObject> objects, ParseException e) {
		//now that we have pulled a parseobject we can get the image url
		//to load into the pop up diagram
		String imageUrl = (String) objects.get(0).get("imageLink");
		ImageView iv = (ImageView) findViewById(R.id.image_workout);
		Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
	}
});
}
});

};
if (muscleLabel.contentEquals("Legs")){
RandoButton.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
String item = (String) legArray.get(randomGenerator.nextInt(legArray.size()));
((TextView)findViewById(R.id.random_work)).setText(item);

ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
query.whereEqualTo("exercise", item);
query.findInBackground(new FindCallback<ParseObject>() {
	
	@Override
	public void done(List<ParseObject> objects, ParseException e) {
		//now that we have pulled a parseobject we can get the image url
		//to load into the pop up diagram
		String imageUrl = (String) objects.get(0).get("imageLink");
		ImageView iv = (ImageView) findViewById(R.id.image_workout);
		Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
	}
});
}
});

};
if (muscleLabel.contentEquals("Shoulders")){
RandoButton.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
String item = (String) shoulderArray.get(randomGenerator.nextInt(shoulderArray.size()));
((TextView)findViewById(R.id.random_work)).setText(item);

ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
query.whereEqualTo("exercise", item);
query.findInBackground(new FindCallback<ParseObject>() {
	
	@Override
	public void done(List<ParseObject> objects, ParseException e) {
		//now that we have pulled a parseobject we can get the image url
		//to load into the pop up diagram
		String imageUrl = (String) objects.get(0).get("imageLink");
		ImageView iv = (ImageView) findViewById(R.id.image_workout);
		Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
	}
});
}
});

};


if (muscleLabel.contentEquals("Body Weight")){
RandoButton.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
String item = (String) bodyArray.get(randomGenerator.nextInt(bodyArray.size()));
((TextView)findViewById(R.id.random_work)).setText(item);

ParseQuery<ParseObject> query = ParseQuery.getQuery("Exercises");
query.whereEqualTo("exercise", item);
query.findInBackground(new FindCallback<ParseObject>() {
	
	@Override
	public void done(List<ParseObject> objects, ParseException e) {
		//now that we have pulled a parseobject we can get the image url
		//to load into the pop up diagram
		String imageUrl = (String) objects.get(0).get("imageLink");
		ImageView iv = (ImageView) findViewById(R.id.image_workout);
		Picasso.with(SpecificMuscleGroupActivity.this).load(imageUrl).into(iv);
	}
});
}
});

};

	}

	}
	

