package com.example.bodybro;

import java.io.Serializable;

public class HistoryItem implements Serializable{
	String name, date, workoutType, workoutExercise, reps, weight;

	public HistoryItem(String name, String date, String workoutType,
			String workoutExercise, String reps, String weight) {
		super();
		this.name = name;
		this.date = date;
		this.workoutType = workoutType;
		this.workoutExercise = workoutExercise;
		this.reps = reps;
		this.weight = weight;
	}
	
	public HistoryItem(String name, String date, String workoutType,
			String workoutExercise) {
		super();
		this.name = name;
		this.date = date;
		this.workoutType = workoutType;
		this.workoutExercise = workoutExercise;
		reps = null;
		weight = null;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reps == null) ? 0 : reps.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result
				+ ((workoutExercise == null) ? 0 : workoutExercise.hashCode());
		result = prime * result
				+ ((workoutType == null) ? 0 : workoutType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryItem other = (HistoryItem) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reps == null) {
			if (other.reps != null)
				return false;
		} else if (!reps.equals(other.reps))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (workoutExercise == null) {
			if (other.workoutExercise != null)
				return false;
		} else if (!workoutExercise.equals(other.workoutExercise))
			return false;
		if (workoutType == null) {
			if (other.workoutType != null)
				return false;
		} else if (!workoutType.equals(other.workoutType))
			return false;
		return true;
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

	
	
	
}
