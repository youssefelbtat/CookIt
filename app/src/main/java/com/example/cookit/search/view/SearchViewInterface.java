package com.example.cookit.search.view;

import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.MealModel;

import java.util.List;

public interface SearchViewInterface {

    public void getMeal(List<MealModel> Meals);

    public void getAllCategories(List<Category> categories);

    public void getAllCountries(List<Country> countries);

    public void getAllIngredient(List<Ingredient> ingredients);

    public void getMeals(List<MealModel> mealModels);

    public void addToFavorite (MealModel mealModel);

}
