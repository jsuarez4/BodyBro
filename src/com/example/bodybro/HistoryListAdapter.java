package com.example.bodybro;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HistoryListAdapter extends ArrayAdapter<HistoryItem>{
	List<HistoryItem> historyList;
	int resource;
	Context context;
	
	public HistoryListAdapter(Context context, int resource,
			List<HistoryItem> objects) {
		super(context, resource, objects);
		this.historyList = objects;
		this.resource = resource;
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resource, parent, false);
		}
		
		//pull the current history item from the list that's given to us
		HistoryItem historyItem = historyList.get(position);
		
		//pull the use workout button which moves to the create workout activity class
		Button btnUseWorkout = (Button) convertView.findViewById(R.id.button_use_workout);
		btnUseWorkout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//TODO: need to add extras to the intent so that we setup the create workout activity
				//to reflect the history's workout
				
				//make an intent to go to the create workout activity
				Intent intent = new Intent(context, CreateWorkoutActivity.class);
				//start the create workout activity
				context.startActivity(intent);
			}
		});
		
		//attach logic to the text views on each row in this list
		TextView tvHistoryDate = (TextView) convertView.findViewById(R.id.text_view_history_date);
		TextView tvHistoryName = (TextView) convertView.findViewById(R.id.text_view_history_name);
		TextView tvHistoryWorkoutType = (TextView) convertView.findViewById(R.id.text_view_history_workout_type);
		
		//set those text views to the historyItem data
		tvHistoryDate.setText("Date: " + historyItem.getDate());
		tvHistoryName.setText("Name: " + historyItem.getName());
		tvHistoryWorkoutType.setText("Workout Type: " + historyItem.getWorkoutType());
		
		return convertView;
	}
}
