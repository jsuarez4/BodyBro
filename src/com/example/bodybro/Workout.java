package com.example.bodybro;

public class Workout {
	
	/*
	 * muscleGroup = Chest, Arms, Legs, etc
	 * name = Curls, Flies, Bench, etc
	 */
	String exercise;

	public Workout(String exercise) {
		super();
//		this.muscleGroup = position;
		this.exercise = exercise;
//		this.reps = reps;
//		this.weight = weight;
	}



	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}


	@Override
	public String toString() {
		return "Workout [exercise=" + exercise + "]";
	}


	
	
}
