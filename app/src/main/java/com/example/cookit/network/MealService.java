package com.example.cookit.network;

import com.example.cookit.model.Category;
import com.example.cookit.model.CategoryResponse;
import com.example.cookit.model.Country;
import com.example.cookit.model.CountryResponse;
import com.example.cookit.model.Ingredient;
import com.example.cookit.model.IngredientResponse;
import com.example.cookit.model.MealModelResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MealService {
    @GET("random.php")
    Flowable<MealModelResponse> getRandomMeals();

    @GET("categories.php")
    Single<CategoryResponse> getAllCategories();

    @GET("list.php?a=list")
    Single<CountryResponse> getAllCountries();

    @GET("list.php?i=list")
    Single<IngredientResponse> getAllIngredient();

    @GET("search.php")
    Single<MealModelResponse> getMealsByName(@Query("s") String name);

    @GET("filter.php")
    Single<MealModelResponse> getMealsByCategories(@Query("c") String category);

    @GET("filter.php")
    Single<MealModelResponse> getMealsByCountries(@Query("a") String country);

    @GET("filter.php")
    Single<MealModelResponse> getMealsByIngredients(@Query("i") String ingredient);



}
