package com.example.bodybro;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class CreateWorkoutListAdapter extends ArrayAdapter<Workout>{
	//list of the workouts received from the list in createworkout activity
	List<Workout> workoutList;
	//this is the list_view_create_workout.xml resource
	int resource;
	//createworkoutactivity is context
	Context context;
	
	public CreateWorkoutListAdapter(Context context, int resource,
			List<Workout> objects) {
		
		super(context, resource, objects);
		this.workoutList = objects;
		this.resource = resource;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resource, parent, false);
		}
		
		//pull the currently selected workout from the list
		Workout selectedWorkout = workoutList.get(position);
		
		
		TextView workMuscle = (TextView)convertView.findViewById(R.id.text_view_list_view_workout_type);
		//this is the reps box located in list_view_create_workout.xml
		EditText repBox = (EditText) convertView.findViewById(R.id.edit_text_list_view_create_reps);
		repBox.setHint("Enter your reps, bro");
		
		//weightbox
		EditText weightBox = (EditText) convertView.findViewById(R.id.edit_text_list_view_create_weight);
		weightBox.setHint("Enter your weight, bro");
		
		//textview that represents the exercise such as "bench", "curls", etc
		EditText exersizeBox = (EditText) convertView.findViewById(R.id.edit_text_list_view_create_exersize);
		exersizeBox.setText("exersize name");
		
		return convertView;
	}
	
	

	
}
