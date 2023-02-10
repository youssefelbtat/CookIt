package com.example.cookit.model.retrofit;

import com.example.cookit.network.NetworkDelegate;


public interface RepositoryInterface {
    void getRandomMeal(NetworkDelegate networkDelegate);
    void getAllCategories(NetworkDelegate networkDelegate);

    void getAllCountries(NetworkDelegate networkDelegate);

    void getAllIngredient(NetworkDelegate networkDelegate);

    void getMealsByName(NetworkDelegate networkDelegate,String name);

    void getMealsByCategories(NetworkDelegate networkDelegate,String category);

    void getMealsByCountries(NetworkDelegate networkDelegate,String country);

    void getMealsByIngredients(NetworkDelegate networkDelegate,String ingredient);
}
