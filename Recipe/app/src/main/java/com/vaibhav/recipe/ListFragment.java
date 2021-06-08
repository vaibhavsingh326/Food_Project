package com.vaibhav.recipe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vaibhav.recipe.ApiService;
import com.vaibhav.recipe.MealAdapter;
import com.vaibhav.recipe.MealsItem;
import com.vaibhav.recipe.Network;
import com.vaibhav.recipe.R;
import com.vaibhav.recipe.ResponseForArea;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    private RecyclerView mRvRecycle;
    private  int type;
    private String area;
    private List<MealsItem> mealsItemList = new ArrayList<>();
    private MealAdapter mealAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Vaibhav","ListObhjne");

        if (getArguments()!=null&&getArguments().getInt("type")!=0&&getArguments().getString("area")!=null){
            Log.d("Vaibhav","ListOnvhje");

            type = getArguments().getInt("type");
            area = getArguments().getString("area");
            fetchData(area, type);
        }
    }

    private void fetchData(String area,int type) {
        ApiService apiService2 = Network.getRetrofitInstance(getContext()).create(ApiService.class);
        switch (type){
            case 1:
                Log.d("Vaibhav","1");

                Call<ResponseForArea> call = apiService2.getResponseForArea(area);
                call.enqueue(new Callback<ResponseForArea>() {
                    @Override
                    public void onResponse(Call<ResponseForArea> call, Response<ResponseForArea> response) {
                        if (response.code()== HttpURLConnection.HTTP_OK){
                            ResponseForArea responseForArea =response.body();
                            mealsItemList = responseForArea.getMeals();
                            Toast.makeText(getContext(),mealsItemList.get(0).getStrMeal(),Toast.LENGTH_SHORT).show();
                            mealAdapter.updateData(mealsItemList);
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseForArea> call, Throwable t) {

                    }
                });
                break;
            case 2:
                Log.d("Vaibhav","12");

                Call<ResponseForArea> call1 = apiService2.getResponseForCategory(area);
                call1.enqueue(new Callback<ResponseForArea>() {
                    @Override
                    public void onResponse(Call<ResponseForArea> call, Response<ResponseForArea> response) {
                        if (response.code()== HttpURLConnection.HTTP_OK){
                            ResponseForArea responseForArea =response.body();
                            mealsItemList = responseForArea.getMeals();
                            mealAdapter.updateData(mealsItemList);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseForArea> call, Throwable t) {


                    }
                });
                break;
            case 3:
                Log.d("Vaibhav","3");

                Call<ResponseForArea> call2 = apiService2.getResponseForIngredient(area);
                call2.enqueue(new Callback<ResponseForArea>() {

                    @Override
                    public void onResponse(Call<ResponseForArea> call, Response<ResponseForArea> response) {
                        if (response.code()== HttpURLConnection.HTTP_OK){
                            ResponseForArea responseForArea =response.body();
                            mealsItemList = responseForArea.getMeals();
                            Toast.makeText(getContext(),mealsItemList.get(0).getStrMeal(),Toast.LENGTH_SHORT).show();

                            Log.d("Vaibhav","3");
                            mealAdapter.updateData(mealsItemList);


                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseForArea> call, Throwable t) {
                        Log.d("Vaibhav1","3");

                    }
                });
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRvRecycle = view.findViewById(R.id.rvRecycleList);
        setRecyclerAdapter();

    }

    private void setRecyclerAdapter() {
        mealAdapter = new MealAdapter(mealsItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRvRecycle.setLayoutManager(linearLayoutManager);
        mRvRecycle.setAdapter(mealAdapter);

    }
}