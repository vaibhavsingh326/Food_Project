package com.vaibhav.recipe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MealViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvItem;
    private CardView mCvWholeItem;
    private ImageView mIvImage;

    public MealViewHolder(@NonNull View itemView) {
        super(itemView);
        mCvWholeItem = itemView.findViewById(R.id.cvWholeItem);
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvItem = itemView.findViewById(R.id.tvItem);
        mCvWholeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setData(MealsItem mealsItem) {
        mTvItem.setText(mealsItem.getStrMeal());
        Glide.with(mIvImage).load(mealsItem.getStrMealThumb()).into(mIvImage);
    }
}
