package com.example.bodybro;

public class Workout {
	int muscleGroup;
	/*
	 * muscleGroup = Chest, Arms, Legs, etc
	 * name = Curls, Flies, Bench, etc
	 */
	String exercise, reps, weight;

	public Workout(int position, String exercise, String reps, String weight) {
		super();
		this.muscleGroup = position;
		this.exercise = exercise;
		this.reps = reps;
		this.weight = weight;
	}

	public int getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(int muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
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

	@Override
	public String toString() {
		return "Workout [muscleGroup=" + muscleGroup + ", exercise=" + exercise
				+ ", reps=" + reps + ", weight=" + weight + "]";
	}



	
	
}
