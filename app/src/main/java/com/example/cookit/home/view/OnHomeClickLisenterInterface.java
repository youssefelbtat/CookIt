package com.example.cookit.home.view;

import com.example.cookit.model.MealModel;

public interface OnHomeClickLisenterInterface {
    void addToFavoriteOnClick(MealModel mealModel);
    void nevToItemPage(MealModel model);
}
