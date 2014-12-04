package com.example.bodybro;

public class HistoryItem {
	String name, date, workoutType, workoutExercise;

	public HistoryItem(String name, String date, String workoutType,
			String workoutExercise) {
		super();
		this.name = name;
		this.date = date;
		this.workoutType = workoutType;
		this.workoutExercise = workoutExercise;
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

	public String getWorkoutExercise() {
		return workoutExercise;
	}

	public void setWorkoutExercise(String workoutExercise) {
		this.workoutExercise = workoutExercise;
	}

	
	
}
