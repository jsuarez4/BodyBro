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
	List<Workout> workoutList;
	int resource;
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
		Workout selectedWorkout = workoutList.get(position);
		
		EditText repBox = (EditText) convertView.findViewById(R.id.edit_text_list_view_create_reps);
		repBox.setHint("Enter your reps, bro");
		EditText weightBox = (EditText) convertView.findViewById(R.id.edit_text_list_view_create_weight);
		weightBox.setHint("Enter your weight, bro");
		TextView label = (TextView) convertView.findViewById(R.id.text_view_list_view_create_label);
		label.setText(selectedWorkout.getName());
		
		return convertView;
	}
	
	

	
}
