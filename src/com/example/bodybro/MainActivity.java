package com.example.bodybro;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//initializing Parse.com stuff
		Parse.initialize(this, "05Bkc0xDEqMmdoXxvsGFodE8X55Ci3s1huL2yBh7", "uYz8u93WCYH509Zgc2GmOHd0VdnqE4ZHVCQsL85q");
		
		//setting up the workout button
		Button buttonWorkout = (Button) findViewById(R.id.button_workout);
		buttonWorkout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//when the button is clicked, open the MuscleGrouopActivity
				startActivity(new Intent(MainActivity.this, MuscleGroupActivity.class));
			}
		});
		
		//setting up the history button
		Button buttonHistory = (Button) findViewById(R.id.button_history);
		buttonHistory.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//when the button is clicked, open the HistoryActivity
				startActivity(new Intent(MainActivity.this, HistoryActivity.class));
			}
		});
	}
}
