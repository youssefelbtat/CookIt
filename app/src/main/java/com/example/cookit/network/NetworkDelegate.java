package com.example.cookit.network;

import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.MealModel;

import java.util.List;


public interface NetworkDelegate {

    public void onSuccessMeals(List<MealModel> mealModels);

    public void onSuccessCategories(List<Category> categoryList);

    public void onSuccessCountries(List<Country> countries);

    public void onSuccessIngredients(List<Ingredient> ingredients);

    public void onFailurResult(String message);
}
