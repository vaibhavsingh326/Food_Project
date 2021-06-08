package com.vaibhav.recipe;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseForList implements Serializable {

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public List<CategoriesItem> getCategories(){
		return categories;
	}
}