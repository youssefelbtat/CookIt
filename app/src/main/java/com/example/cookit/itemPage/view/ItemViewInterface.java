package com.example.cookit.itemPage.view;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface ItemViewInterface {

    void ViewMealItem(MealModel meal);

    void addMealToPlan(MealModel Meal);

    public void addToFavorite (MealModel mealModel);
}
