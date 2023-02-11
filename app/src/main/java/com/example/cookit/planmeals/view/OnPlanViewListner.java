package com.example.cookit.planmeals.view;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface OnPlanViewListner {
    void removeMealFromPlaned(MealModel meal);

    public void ViewData(List<MealModel> Meals);
}
