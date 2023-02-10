package com.example.cookit.home.view;

import com.example.cookit.model.Category;
import com.example.cookit.model.Country;
import com.example.cookit.model.MealModel;

import java.util.List;

public interface HomeViewInterface {
    void ViewRandomMeal(List<MealModel> models);
    void ViewCountriesList(List<Country> models);
    void ViewCategoriesList(List<Category> models);
    void addMealToFav(MealModel Meal);
}
