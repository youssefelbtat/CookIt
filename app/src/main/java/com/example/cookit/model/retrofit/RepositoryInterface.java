package com.example.cookit.model.retrofit;

import com.example.cookit.model.MealModel;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public interface RepositoryInterface {
    void getRandomMeal(NetworkDelegate networkDelegate);
    void getAllCategories(NetworkDelegate networkDelegate);

    void getAllCountries(NetworkDelegate networkDelegate);

    void getAllIngredient(NetworkDelegate networkDelegate);

    void getMealsByName(NetworkDelegate networkDelegate,String name);
    void getMealsByFirstChar(NetworkDelegate networkDelegate,String name);

    void getMealsByCategories(NetworkDelegate networkDelegate,String category);

    void getMealsByCountries(NetworkDelegate networkDelegate,String country);

    void getMealsByIngredients(NetworkDelegate networkDelegate,String ingredient);

    void insertFavorite(MealModel mealModel);
    void removeFavorite(MealModel mealModel);
    Single<List<MealModel>> getAllStoredFavorites();
    void insertPlan(MealModel mealModel);
    void removePlan(MealModel mealModel);
    Single<List<MealModel>> getAllStoredPlans();


}
