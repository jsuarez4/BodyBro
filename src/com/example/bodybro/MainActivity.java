package com.example.bodybro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class MainActivity extends Activity {
	static boolean isShownSplashScreen = false;
	
	@Override
	protected void onResume() {
		super.onResume();
		//if this app is being opened for the first time, show splash screen
		if (!isShownSplashScreen){
			isShownSplashScreen = true;
			startActivity(new Intent(MainActivity.this, SplashScreenActivity.class));
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Body Bro");
		ParseUser currentUser = ParseUser.getCurrentUser();
		if(currentUser == null){
			//if there is no current user, then start the login activity
			startActivity(new Intent(MainActivity.this, LoginActivity.class));
		} else {
			//if there is a current user then put the username at the bottom of the screen
			((TextView)findViewById(R.id.text_view_username)).setText("Logged in as: " + currentUser.getUsername());
			Button buttonLogout = (Button)findViewById(R.id.Log_out_btn);
			buttonLogout.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ParseUser.logOut();
					Intent intent = new Intent(MainActivity.this,LoginActivity.class);
					startActivity(intent);
					finish();
				}
			});
		}
		
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
