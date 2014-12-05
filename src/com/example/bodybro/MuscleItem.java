package com.example.bodybro;

public class MuscleItem {

	String name, date, workoutType, workoutExercise,reps,weight;

	public MuscleItem(String name, String date, String workoutType,
			String workoutExercise,String reps, String weight) {
		super();
		this.name = name;
		this.date = date;
		this.workoutType = workoutType;
		this.workoutExercise = workoutExercise;
		this.reps = reps;
		this.weight=weight;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

