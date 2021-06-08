package com.vaibhav.recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/json/v1/1/filter.php")
    Call<ResponseForArea> getResponseForArea(@Query("a") String a);

    @GET("api/json/v1/1/filter.php")
    Call<ResponseForArea> getResponseForCategory(@Query("c") String c);

    @GET("api/json/v1/1/filter.php")
    Call<ResponseForArea> getResponseForIngredient(@Query("i") String i);

    @GET("api/json/v1/1/categories.php")
    Call<ResponseForList> getResponseForList();
}
