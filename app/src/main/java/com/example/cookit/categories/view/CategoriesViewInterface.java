package com.example.cookit.categories.view;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface CategoriesViewInterface {

    void ViewCategoriesMeal(List<MealModel> models);
    void addMealToFav(MealModel Meal);
}
