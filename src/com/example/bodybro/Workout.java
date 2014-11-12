package com.example.bodybro;

public class Workout {
	/*
	 * muscleGroup = Chest, Arms, Legs, etc
	 * name = Curls, Flies, Bench, etc
	 */
	String muscleGroup, name, reps, weight;

	public Workout(String muscleGroup, String name, String reps, String weight) {
		super();
		this.muscleGroup = muscleGroup;
		this.name = name;
		this.reps = reps;
		this.weight = weight;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Workout [muscleGroup=" + muscleGroup + ", name=" + name
				+ ", reps=" + reps + ", weight=" + weight + "]";
	}
	
	
}
