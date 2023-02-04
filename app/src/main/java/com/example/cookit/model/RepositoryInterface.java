package com.example.cookit.model;

import androidx.lifecycle.LiveData;

import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public interface RepositoryInterface {
    public void removeMealFromFav(MealModel mealModel);
    public void insertMeal(MealModel mealModel);
    public LiveData<List<MealModel>> getFavMealslList();
    public void getAllProducts(NetworkDelegate networkDelegate);
}
