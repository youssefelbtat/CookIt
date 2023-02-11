package com.example.cookit.countries.view;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface CountriesViewInterface {
    void ViewCounteryMeal(List<MealModel> models);
    public void addToFavorite (MealModel mealModel);

}
