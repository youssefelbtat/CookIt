package com.example.cookit.categories.presenter;

import com.example.cookit.model.MealModel;

public interface CategoriesPresenterInterface {
    void getMeals(String categories);

    public void addToFavorite(MealModel mealModel);

}
