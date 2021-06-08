package com.vaibhav.recipe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vaibhav.recipe.ApiService;
import com.vaibhav.recipe.Network;
import com.vaibhav.recipe.R;
import com.vaibhav.recipe.ResponseForList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fetchData();
    }

    private void fetchData() {
        ApiService apiService1 = Network.getRetrofitInstance(getContext()).create(ApiService.class);
        Call<ResponseForList> call = apiService1.getResponseForList();
        call.enqueue(new Callback<ResponseForList>() {
            @Override
            public void onResponse(Call<ResponseForList> call, Response<ResponseForList> response) {

            }

            @Override
            public void onFailure(Call<ResponseForList> call, Throwable t) {

            }
        });
    }
}