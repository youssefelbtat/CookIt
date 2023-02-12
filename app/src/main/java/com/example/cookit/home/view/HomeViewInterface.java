package com.example.cookit.home.view;


import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;

import java.util.List;

public interface HomeViewInterface {
    void ViewRandomMeal(List<MealModel> models);
    void ViewCountriesList(List<Country> models);
    void ViewCategoriesList(List<Category> models);
    public void addToFavorite (MealModel mealModel);

    void insertDataInRoom(MealModel mealModel);
}
