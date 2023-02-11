package com.example.cookit.countries.presenter;

import com.example.cookit.model.MealModel;

public interface CountriesPresenterInterface {
    void getMeals(String country);

    public void addToFavorite(MealModel mealModel);
}
