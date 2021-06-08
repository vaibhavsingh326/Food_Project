package com.vaibhav.recipe;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseForArea implements Serializable {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public ResponseForArea(List<MealsItem> meals) {
		this.meals = meals;
	}

	public List<MealsItem> getMeals(){
		return meals;
	}
}