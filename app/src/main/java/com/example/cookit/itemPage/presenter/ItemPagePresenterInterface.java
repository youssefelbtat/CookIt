package com.example.cookit.itemPage.presenter;

import com.example.cookit.model.MealModel;

public interface ItemPagePresenterInterface {
    void getMealItem(String ItemName);

    public void addToFavorite(MealModel mealModel);
}
