package com.example.bodybro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateWorkoutActivity extends Activity {
	//list of workouts located on the screen
	List<Workout> workoutList;
	CreateWorkoutListAdapter listViewAdapter;
	ListView listView;
	
	//layout for dropdown
	private LinearLayout Musclelayout;
	
	//textview holding title 
	private TextView DropDownMuscleM;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_workout);
		
		
		
		//list view
		listView = (ListView) findViewById(R.id.list_view_create_workout);
		workoutList = new ArrayList<Workout>();

		
		Musclelayout = ((LinearLayout)findViewById(R.id.dropdown_foldout_menu));
		DropDownMuscleM = ((TextView)findViewById(R.id.dropdown_textview));
		
		
		final TextView DropdownText = (TextView)findViewById(R.id.dropdown_textview);
		final TextView drop_downselect_Chest = (TextView)findViewById(R.id.dropdown_Chest);
		final TextView drop_downselect_Back = (TextView)findViewById(R.id.dropdown_Back);
		final TextView drop_downselect_Shoulders = (TextView)findViewById(R.id.dropdown_Shoulders);
		final TextView drop_downselect_Legs = (TextView)findViewById(R.id.dropdown_Legs);
		final TextView drop_downselect_Arms = (TextView)findViewById(R.id.dropdown_Arms);
		final TextView drop_downselect_Body_W = (TextView)findViewById(R.id.dropdown_BodyW);
		
		DropdownText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (Musclelayout.getVisibility() == View.GONE)
				{
					openDropdown();
				}
				else{
					closeDropdown();
				}
			}
		});
		drop_downselect_Chest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Chest);
                closeDropdown(); 
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
    				//add a new workout to the list
    				Workout workout = new Workout("Chest", "Bench", "3", "100");
    				workoutList.add(workout);
    				
    				//setup the adapter to create the list view
    				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
    				
    				//notify that the list has been changed
    				listViewAdapter.notifyDataSetChanged();
    				
    				//set the adapter to the list view on the UI
    				listView.setAdapter(listViewAdapter);   
                
                
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Chest, Toast.LENGTH_SHORT).show();
                
			}
		});
		
		drop_downselect_Shoulders.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Shoulders);
                closeDropdown(); 
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter); 
                
                
                
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Shoulders, Toast.LENGTH_SHORT).show();				
			}
		});
		drop_downselect_Legs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Legs);
                closeDropdown(); 
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter); 
                
                
                
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Legs, Toast.LENGTH_SHORT).show();				
			}
		});
		drop_downselect_Arms.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Arms);
                closeDropdown(); 
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
                
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter); 
                
                
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Arms, Toast.LENGTH_SHORT).show();				
			}
		});
		drop_downselect_Body_W.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Body_W);
                closeDropdown(); 
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
                
                
                
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter); 
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Body_W, Toast.LENGTH_SHORT).show();				
			}
		});
		drop_downselect_Back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                DropdownText.setText(R.string.drop_downselect_Back);
                closeDropdown(); 
                drop_downselect_Back.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                        R.drawable.icn_dropdown_checked, 0);
                drop_downselect_Shoulders.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Chest.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Legs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Arms.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                drop_downselect_Body_W.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                
                
                
				//add a new workout to the list
				Workout workout = new Workout("Chest", "Bench", "3", "100");
				workoutList.add(workout);
				
				//setup the adapter to create the list view
				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
				
				//notify that the list has been changed
				listViewAdapter.notifyDataSetChanged();
				
				//set the adapter to the list view on the UI
				listView.setAdapter(listViewAdapter); 
                Toast.makeText(getBaseContext(), R.string.drop_downselect_Back, Toast.LENGTH_SHORT).show();				
			}
		});

		
		
		

		
//		//initialize the new row button
//		Button buttonNewRow = (Button) findViewById(R.id.button_new_row);
//		buttonNewRow.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				//add a new workout to the list
//				Workout workout = new Workout("Chest", "Bench", "3", "100");
//				workoutList.add(workout);
//				
//				//setup the adapter to create the list view
//				listViewAdapter = new CreateWorkoutListAdapter(CreateWorkoutActivity.this, R.layout.list_view_create_workout, workoutList);
//				
//				//notify that the list has been changed
//				listViewAdapter.notifyDataSetChanged();
//				
//				//set the adapter to the list view on the UI
//				listView.setAdapter(listViewAdapter);
//			}
//		});
	}

	//animate out droplist
	protected void closeDropdown() {
        if (Musclelayout.getVisibility() == View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            anim.setAnimationListener(new AnimationListener() {
                @Override 
                public void onAnimationStart(Animation animation) {
                } 
 
 
                @Override 
                public void onAnimationRepeat(Animation animation) {
                } 
 
 
                @Override 
                public void onAnimationEnd(Animation animation) {
                    Musclelayout.setVisibility(View.GONE);
                } 
            }); 
            DropDownMuscleM.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.icn_dropdown_open, 0);
            Musclelayout.startAnimation(anim);
        } 
    } 
	

//animate in drop downlist
	protected void openDropdown() {
        if (Musclelayout.getVisibility() != View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            Musclelayout.startAnimation(anim);
            DropDownMuscleM.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.icn_dropdown_close, 0);
            Musclelayout.setVisibility(View.VISIBLE);
        } 
		
	}
	
	
}
