package com.example.cookit.network;

import com.example.cookit.model.Category;
import com.example.cookit.model.Country;
import com.example.cookit.model.Ingredient;
import com.example.cookit.model.MealModelResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RemoteSource {

    void getRandomMeals(NetworkDelegate networkDelegate);

    void getAllCategories(NetworkDelegate networkDelegate);

    void getAllCountries(NetworkDelegate networkDelegate);

    void getAllIngredient(NetworkDelegate networkDelegate);

    void getMealsByName(NetworkDelegate networkDelegate, String name);

    void getMealsByCategories(NetworkDelegate networkDelegate, String category);

    void getMealsByCountries(NetworkDelegate networkDelegate, String country);

    void getMealsByIngredients(NetworkDelegate networkDelegate, String ingredient);

}
