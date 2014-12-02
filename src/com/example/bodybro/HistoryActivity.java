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
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class HistoryActivity extends Activity {
	List<HistoryItem> historyList;
	ProgressDialog historyLoadingDialog;
	
	@Override
	protected void onResume() {
		super.onResume();
		//loading dialog to show that we're retrieving info from server
		historyLoadingDialog = new ProgressDialog(HistoryActivity.this);
		historyLoadingDialog.setIndeterminate(true);
		historyLoadingDialog.setTitle("Loading...");
		historyLoadingDialog.setMessage("Retrieving history from server, please wait...");
		historyLoadingDialog.show();
		
		historyList = new ArrayList<HistoryItem>();
		
		//pull the current user
		ParseUser currentUser = ParseUser.getCurrentUser();
		
		//create a parsequery for the history table then query for all the user's history
		ParseQuery<ParseObject> query = ParseQuery.getQuery("History");
		query.whereEqualTo("user", currentUser.getUsername());
		
		//go
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		           //it worked, now add all of the history data into historyItem objects then put them in a list
		           for (ParseObject obj : scoreList) {
		        	   //pull info from database
		        	   String name = obj.getString("user");
		        	   Date date = obj.getUpdatedAt();
		        	   String workoutType = obj.getString("workoutType");
		        	   
		        	   //make history item out of the info then place it in a list
		        	   HistoryItem newHistoryItem = new HistoryItem(name, date.toString(), workoutType);
		        	   historyList.add(newHistoryItem);
		           }
		           
			   		//now populate the list on this activity
			   		ListView historyListView = (ListView) findViewById(R.id.list_view_history);
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
		
		//end the loading dialog
		historyLoadingDialog.dismiss();
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		

		
		
	}
}
