package com.vaibhav.recipe;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MealsItem implements Serializable {

	@SerializedName("strMeal")
	private String strMeal;

	@SerializedName("strMealThumb")
	private String strMealThumb;

	@SerializedName("idMeal")
	private String idMeal;

	public MealsItem(String strMeal, String strMealThumb, String idMeal) {
		this.strMeal = strMeal;
		this.strMealThumb = strMealThumb;
		this.idMeal = idMeal;
	}

	public String getStrMeal(){
		return strMeal;
	}

	public String getStrMealThumb(){
		return strMealThumb;
	}

	public String getIdMeal(){
		return idMeal;
	}
}