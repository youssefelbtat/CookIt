package com.example.cookit.itemPage.view;

import com.example.cookit.model.MealModel;

public interface OnItemPageClickListenerInterface {

    void addToFavoriteOnClick(MealModel mealModel);

    void addToWeakPlanOnclick(MealModel mealModel);

}
