package com.example.bodybro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class CreateWorkoutActivity extends Activity {
	//list of workouts located on the screen
	List<Workout> workoutList;
	CreateWorkoutListAdapter listViewAdapter;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_workout);
		
		//list view
		listView = (ListView) findViewById(R.id.list_view_create_workout);
		workoutList = new ArrayList<Workout>();
		
		//initialize the new row button
		Button buttonNewRow = (Button) findViewById(R.id.button_new_row);
		buttonNewRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter);
			}
		});
	}
}
