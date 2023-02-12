package com.example.cookit.planmeals.view;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.modelFirebase.UserModel;

import java.util.List;

public interface OnPlanViewListner {
    void removeMealFromPlaned(MealModel meal);

    public void ViewData(List<MealModel> Meals);

    public void uploadPlanInFirebase(UserModel userModel);

    public void addToFavorite (MealModel mealModel);
}
