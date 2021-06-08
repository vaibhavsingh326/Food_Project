package com.vaibhav.recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealViewHolder> {
    private List<MealsItem> mealsItemList;

    public MealAdapter(List<MealsItem> mealsItemList) {
        this.mealsItemList = mealsItemList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        MealsItem mealsItem = mealsItemList.get(position);
        holder.setData(mealsItem);
    }
    public void updateData(List<MealsItem> mealsItemList){
        this.mealsItemList = mealsItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mealsItemList.size();
    }
}
