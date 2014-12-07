package com.example.bodybro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.ClipData.Item;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryActivity extends Activity {
	List<HistoryItem> historyList;
	//this will be used to filter by workoutType
	String filterByWorkoutType = null;
	String[] dropdownItems = {"All", "Arms", "Legs", "Chest", "Back", "Body Weight"};
	ParseUser currentUser;
	
	@Override
	protected void onResume() {
		super.onResume();
		
		//pull the current user
		currentUser = ParseUser.getCurrentUser();
	
		//show who is logged in at top of screen
		TextView tvLoggedInAs = (TextView) findViewById(R.id.text_view_history_logged_in_as);
		tvLoggedInAs.setText("Logged in as: " + currentUser.getUsername());
		
		//create a parsequery for the history table then query for all the user's history
		ParseQuery<ParseObject> query = ParseQuery.getQuery("History");
		query.whereEqualTo("user", currentUser.getUsername());
		
		//if filterByWorkoutType is null then we do not want to filter out any of the workout types
		if(filterByWorkoutType != null) {
			query.whereEqualTo("workoutType", filterByWorkoutType);
		}
		
		//go make the query
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		           //wipe out the historyList for a new list about to come
		           historyList = new ArrayList<HistoryItem>();
		           //it worked, now add all of the history data into historyItem objects then put them in a list
		           for (ParseObject obj : scoreList) {
		        	   //pull info from database
		        	   String name = obj.getString("user");
		        	   Date date = obj.getUpdatedAt();
		        	   String workoutType = obj.getString("workoutType");
		        	   String workoutExercise = obj.getString("exercise");
		        	   
		        	   //make history item out of the info then place it in a list
		        	   HistoryItem newHistoryItem = new HistoryItem(name, date.toString(), workoutType, workoutExercise);
		        	   historyList.add(newHistoryItem);
		           }
		           
			   		//now populate the list on this activity
			   		ListView historyListView = (ListView) findViewById(R.id.list_view_history);
			   		//clean out the list adapter in case there are leftover items in it
			   		historyListView.setAdapter(null);
			   		//setup the adapter to tell the listview HOW to list the information
			   		HistoryListAdapter historyListViewAdapter = new HistoryListAdapter(HistoryActivity.this, R.layout.list_view_history_component, historyList);
			   		//attach the adapter to the listview so that it is drawn to the screen
			   		historyListView.setAdapter(historyListViewAdapter);
		        } else {
		        	//something screwed up
		            Toast.makeText(HistoryActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
		        }
		    }
		});
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		//spinner is the dropdown box
		Spinner dropdownBox = (Spinner) findViewById(R.id.dropdown_muscle_group);
		//basic adapter to make the dropdown box list things correctly
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dropdownItems);
		//attaching adapter to the spinner
		dropdownBox.setAdapter(adapter);
		
		//logic for dropdown box
		dropdownBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				//if position = 0 then user has selected All which means we need to not filter
				if (position != 0) {
					//set filter by to whatever the array has for this position
					filterByWorkoutType = dropdownItems[position].toString();
				} else {
					filterByWorkoutType = null;
				}
				
				//refresh the activity
				onResume();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				//if nothing selected then we want to not filter by anything
				filterByWorkoutType = null;
			}
		});
		
		Button btnDone = (Button) findViewById(R.id.button_done);
		btnDone.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(HistoryActivity.this, MainActivity.class));
			}
		});
		
	}
}

