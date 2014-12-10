package com.example.bodybro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class CreateWorkoutActivity extends Activity implements OnItemSelectedListener{
    	Spinner MuscleGroupSpin,ExerciseSpin;
   	 	ParseUser currentUser;
   	 	EditText etReps;
   	 	EditText etWeight;
   	 	ArrayList<String> muscleGroupArray;
   	 	HistoryItem historyItem;

    	private static final String TAG = CreateWorkoutActivity.class.getName();
    	
    	@Override	    
    	    protected void onCreate(Bundle savedInstanceState) {
    	        super.onCreate(savedInstanceState);
    	        setContentView(R.layout.activity_create_workout);
    	        setTitle("Body Bro");
    	        //spinner objects
    	        MuscleGroupSpin = (Spinner)findViewById(R.id.MuscleType);
    	        ExerciseSpin= (Spinner)findViewById(R.id.WorkOutType);
    	        MuscleGroupSpin.setOnItemSelectedListener(this);  
    	        etReps = (EditText) findViewById(R.id.edit_text_list_view_create_reps);
    	        etWeight = (EditText) findViewById(R.id.edit_text_list_view_create_weight);
    	        
    	        //if extra bundle is not null, then we need to handle incoming bundle from history
    	        if (getIntent().getExtras() != null){
    	        	//populate list to use for muscle group
    	        	muscleGroupArray = new ArrayList<String>();
    	        	muscleGroupArray.add("Arms");
    	        	muscleGroupArray.add("Shoulders");
    	        	muscleGroupArray.add("Legs");
    	        	muscleGroupArray.add("Chest");
    	        	muscleGroupArray.add("Back");
    	        	muscleGroupArray.add("Body Weight");
    	        	
    	        	//strings to store data from incoming bundle
    	        	historyItem = (HistoryItem) getIntent().getExtras().get("historyItem");
    	        	
    	        	//preset all the boxes and things to the bundle
    	        	MuscleGroupSpin.setSelection(muscleGroupArray.indexOf(historyItem.getWorkoutType()));
    	        	etReps.setText(historyItem.getWeight());
    	        	etWeight.setText(historyItem.getReps());
    	        }
  	    
        		//pull the current user
        		currentUser = ParseUser.getCurrentUser();
    	        //starting button when clicked  	        
    			Button btnSave = (Button) findViewById(R.id.label_button_Submit_New);
    			btnSave.setOnClickListener(new View.OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    	    	        //make text from edit text to string 
    	    	        EditText repsInput = (EditText) findViewById(R.id.edit_text_list_view_create_reps);
    	    	        EditText weightInput = (EditText) findViewById(R.id.edit_text_list_view_create_weight);
    	    	        String MuscleInput = MuscleGroupSpin.getSelectedItem().toString();
    	    	        String ExerciseInput= ExerciseSpin.getSelectedItem().toString();
    	    	        //tostring for push to parse
    	    	         String WeightInput = repsInput.getText().toString();
    	    	         String RepsInput  = weightInput.getText().toString();
    	    	         //intent to back to main menu after published 
    					startActivity(new Intent(CreateWorkoutActivity.this, MainActivity.class));
    					//push to parse objects
    					ParseObject CustomWorkOut = new ParseObject("History");
    					CustomWorkOut.put("user",currentUser.getUsername());		
    					CustomWorkOut.put("workoutType", MuscleInput);
    					Log.d(TAG, "workout");   
    					CustomWorkOut.put("weight", WeightInput);
    					Log.d(TAG, "weight");   
    					CustomWorkOut.put("reps", RepsInput);
    					Log.d(TAG, "reps");   
    					CustomWorkOut.put("exercise", ExerciseInput);
    					Log.d(TAG, "exercise");   
    					CustomWorkOut.saveInBackground();
    					Log.d(TAG, "SAVE SUCCESSFUL");   
    					
    				}
    			});
    	        
    	        
    	        
    	    }
    	    @Override// item selected from drop down
    	    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
    	            long arg3) {
    	        // TODO Auto-generated method stub
    	        String MuscleSpin= String.valueOf(MuscleGroupSpin.getSelectedItem());
    	        Toast.makeText(this, MuscleSpin, Toast.LENGTH_SHORT).show();
    	        if(MuscleSpin.contentEquals("Arms")) {
    	        	//make array of list of items based on 1st spinner selections
    	            List<String> list = new ArrayList<String>();

    	            list.add("Barbell Bicep Drag Curl");
    	            list.add("Barbell Curl");
    	            list.add("Dumbbell Alternate Bicep Curl");
    	            list.add("Dumbbell Alternate Hammer Curl");
    	            list.add("Bench Dip");
    	            list.add("Dumbbell Decline Triceps Extension");
    	            list.add("Barbell Reverse Curl");
    	            list.add("Dumbbell Spider Curl");
    	            list.add("Dumbbell Zottman Curl");
    	            list.add("EZ Bar Decline Close Grip Skull Crusher");
    	            list.add("Dumbbell Standing Triceps Extension");
    	            list.add("Dumbbell Tricep Kickbacks");

    	            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	        if(MuscleSpin.contentEquals("Legs")) {
    	        	//make array of list of items based on 1st spinner selections

    	        	List<String> list = new ArrayList<String>();
    	        	list.add("Barbell Deep Squat");
    	        	list.add("Barbell Front Squat");
    	        	list.add("Barbell Squat");
    	        	list.add("Barbell Zercher Squat");
    	        	list.add("Lunge");
    	        	list.add("Dumbbell Jumping Squats");
    	        	list.add("Seated One Leg Calf Raise");
    	        	list.add("Standing Calf Raises");
    	        	list.add("Mountain Climbers");
    	        	list.add("Kettlebell Goblet Squats");
    	        	list.add("Dumbbell Squat");
    	        	list.add("Dumbbell Rear Lunge");
    	        	list.add("Barbell Split Jump");

    	            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter2.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter2);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	        if(MuscleSpin.contentEquals("Shoulders")) {
    	        	//make array of list of items based on 1st spinner selections

    	            List<String> list = new ArrayList<String>();

    	            list.add("Barbell Incline Shoulder Raise");
    	            list.add("Barbell Standing Military Press");
    	            list.add("Dumbbell Alternate Seated Arnold Press");
    	            list.add("Dumbbell Double Incline Shoulder Raise");
    	            list.add("Dumbbell Front Two Raise");
    	            list.add("Dumbbell Lying Rear Delt Raise");
    	            list.add("Weight Plate Shrugs");
    	            list.add("Dumbbell Standing Press");
    	            list.add("Dumbbell Shoulder Shrug");
    	            list.add("Dumbbell Standing Alternate Front Raise");
    	            list.add("Dumbbell Seated Dublin Press");
    	            list.add("Dumbbell Seated Side Lateral Raise");
    	            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	        if(MuscleSpin.contentEquals("Chest")) {
    	        	//make array of list of items based on 1st spinner selections

    	            List<String> list = new ArrayList<String>();
    	            list.add("Barbell Bench Press");
    	            list.add("Barbell Decline Bench Press");
    	            list.add("Barbell Incline Bench Press");
    	            list.add("Bench Pushups");
    	            list.add("Barbell Decline Pullover");
    	            list.add("Butterfly");
    	            list.add("Barbell Neck Press");
    	            list.add("Barbell Wide Grip Bench Press");
    	            list.add("Dumbbell Decline Fly");
    	            list.add("Dumbbell Bench Press");
    	            list.add("Dumbbell Decline Press");
    	            list.add("Dumbbell Incline Press");
    	            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter2.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter2);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	        if(MuscleSpin.contentEquals("Back")) {
    	        	//make array of list of items based on 1st spinner selections

    	        	List<String> list = new ArrayList<String>();
    	        	list.add("Barbell Bent Over Row");
    	        	list.add("Barbell Deadlift");
    	        	list.add("Barbell Good Morning");
    	        	list.add("Barbell Lying Cambered Row");
    	        	list.add("Pull Ups");
    	        	list.add("Reverse Grip Lat Pull Down");
    	        	list.add("Dumbbell Bent Over Row");
    	        	list.add("Dumbbell Deadlift");
    	        	list.add("Dumbbell One Arm Row");
    	        	list.add("Gorilla Chin Up with Crunch");
    	        	list.add("Kettlebell One Arm Row");
    	        	list.add("Wide Grip Rear Pull Ups");
    	        	list.add("Wide Grip Lat Pulldowns");

    	            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	        if(MuscleSpin.contentEquals("Body Weight")) {
    	        	//make array of list of items based on 1st spinner selections

    	            List<String> list = new ArrayList<String>();
    	            list.add("Conveyance");
    	            list.add("Breakfast");
    	            list.add("Crunches");
    	            list.add("Plank");
    	            list.add("Close Hand Pushup");
    	            list.add("Wide Hand Pushup");
    	            list.add("Handstand Pushups");
    	            list.add("Close Triceps Pushup");
    	            list.add("Freehand Jump Squat");
    	            list.add("1 Leg Pushup");
    	            list.add("Mountain Climbers");
    	            list.add("V Ups");
    	            list.add("Twisting Floor Crunch");
    	            list.add("Toe Touchers");

    	            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
    	                android.R.layout.simple_spinner_item, list);
    	            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	            dataAdapter2.notifyDataSetChanged();
    	            ExerciseSpin.setAdapter(dataAdapter2);
    	            
    	            //if history item isn't null, then we have incoming history to deal with
    	            if(historyItem != null){
    	            	//if this list contains the exercise that is in historyItem, set selected to it.
    	            	if (list.contains(historyItem.getWorkoutExercise())){
    	            		ExerciseSpin.setSelection(list.indexOf(historyItem.getWorkoutExercise()));
    	            	}
    	            }
    	        }
    	    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				//if nothing selected then we want to not filter by anything
			}


		
	}


    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    