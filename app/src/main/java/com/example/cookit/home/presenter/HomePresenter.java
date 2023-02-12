package com.example.cookit.home.presenter;


import com.example.cookit.model.MealModel;

import java.util.List;

public interface HomePresenter {
    void getRandomMeal();
    void getCountriesList();
    void getCategoriesList();

    public void addToFavorite(MealModel mealModel);

    void insertDataInRoom(MealModel mealModel);

}
