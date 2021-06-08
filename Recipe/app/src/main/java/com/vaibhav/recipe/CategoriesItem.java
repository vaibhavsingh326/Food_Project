package com.vaibhav.recipe;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CategoriesItem implements Serializable {

	@SerializedName("idCategory")
	private String idCategory;

	@SerializedName("strCategory")
	private String strCategory;

	@SerializedName("strCategoryThumb")
	private String strCategoryThumb;

	@SerializedName("strCategoryDescription")
	private String strCategoryDescription;

	public String getIdCategory(){
		return idCategory;
	}

	public String getStrCategory(){
		return strCategory;
	}

	public String getStrCategoryThumb(){
		return strCategoryThumb;
	}

	public String getStrCategoryDescription(){
		return strCategoryDescription;
	}
}