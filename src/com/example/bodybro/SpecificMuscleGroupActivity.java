package com.example.bodybro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpecificMuscleGroupActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_specific_muscle_group);
		//receive the data attached from MuscleGroupActivity, "Chest", "Arms", etc
		String muscleLabel = getIntent().getExtras().getString(MuscleGroupActivity.MUSCLE_KEY);
		
		//initialize history button
		Button historyButton = (Button) findViewById(R.id.button_history_specific_group);
		historyButton.setText("History: " + muscleLabel);
		

		
		//update the text box with the muscle label sent from the previous activity
		TextView activityTitle = (TextView) findViewById(R.id.text_view_specific_group);
		activityTitle.setText(muscleLabel);
		
	
	}
}
