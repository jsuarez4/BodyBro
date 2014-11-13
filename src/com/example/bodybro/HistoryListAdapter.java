package com.example.bodybro;

import java.util.List;

import android.content.Context;
import android.content.Intent;
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
		
		HistoryItem historyItem = historyList.get(position);
		
		Button btnUseWorkout = (Button) convertView.findViewById(R.id.button_use_workout);
		btnUseWorkout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, CreateWorkoutActivity.class);
			}
		});
		TextView tvHistoryDate = (TextView) convertView.findViewById(R.id.text_view_history_date);
		TextView tvHistoryName = (TextView) convertView.findViewById(R.id.text_view_history_name);
		TextView tvHistoryWorkoutType = (TextView) convertView.findViewById(R.id.text_view_history_workout_type);
		
		
		return convertView;
	}
}
