package com.example.cookit.network;

import com.example.cookit.model.Category;
import com.example.cookit.model.CategoryResponse;
import com.example.cookit.model.Country;
import com.example.cookit.model.CountryResponse;
import com.example.cookit.model.Ingredient;
import com.example.cookit.model.IngredientResponse;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.MealModelResponse;

import java.util.List;


public interface NetworkDelegate {

    public void onSuccessMeals(List<MealModel> mealModels);

    public void onSuccessCategories(List<Category> categoryList);

    public void onSuccessCountries(List<Country> countries);

    public void onSuccessIngredients(List<Ingredient> ingredients);

    public void onFailurResult(String message);
}
