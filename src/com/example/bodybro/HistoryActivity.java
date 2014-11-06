package com.example.bodybro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		
		/**
		 * THIS IS PURELY FOR THE DEMO AND EXTREMELY CLUNKY, FIX LATER
		 * TODO Fix this shizzzz yo.
		 */
		Button armsWorkout = ((Button)findViewById(R.id.button1));
		armsWorkout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//we intend to open the specific muscle group activity
				Intent intent = new Intent(HistoryActivity.this, SpecificMuscleGroupActivity.class);
				//use the tag as a key to map to a value which happens to be the tag also
				intent.putExtra(MuscleGroupActivity.MUSCLE_KEY, "Arms");
				//start the specific muscle group activity now
				startActivity(intent);
			}
		});
		
		Button chestWorkout = (Button) findViewById(R.id.Button01);
		chestWorkout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//we intend to open the specific muscle group activity
				Intent intent = new Intent(HistoryActivity.this, SpecificMuscleGroupActivity.class);
				//use the tag as a key to map to a value which happens to be the tag also
				intent.putExtra(MuscleGroupActivity.MUSCLE_KEY, "Chest");
				//start the specific muscle group activity now
				startActivity(intent);
			}
		});
	}
}
