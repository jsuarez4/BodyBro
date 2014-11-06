package com.example.bodybro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreateWorkoutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_workout);
		
		//initialize the new row button
		Button buttonNewRow = (Button) findViewById(R.id.button_new_row);
		buttonNewRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//represents the main layout
				LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_linear_layout);
				
				//this will represent a new row
				LinearLayout newRow = new LinearLayout(CreateWorkoutActivity.this);
				newRow.setOrientation(LinearLayout.HORIZONTAL);
				
				//a label for the new row
				TextView label = new TextView(CreateWorkoutActivity.this);
				label.setText("This is a new exercise");
				
				//editable boxes to enter reps and weight
				EditText repsBox = new EditText(CreateWorkoutActivity.this);	
				repsBox.setHint("Enter your reps, bro");
				EditText weightBox = new EditText(CreateWorkoutActivity.this);
				weightBox.setHint("Enter your weight, bro");
				
				//replace current row with new stuff
				newRow.removeAllViews();
				newRow.addView(label);
				newRow.addView(repsBox);
				newRow.addView(weightBox);
				
				mainLayout.addView(newRow);
			}
		});
	}
}
