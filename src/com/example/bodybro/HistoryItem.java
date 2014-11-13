package com.example.bodybro;

public class HistoryItem {
	String name, date, workoutType;

	public HistoryItem(String name, String date, String workoutType) {
		super();
		this.name = name;
		this.date = date;
		this.workoutType = workoutType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
	
}
