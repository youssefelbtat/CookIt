package com.example.cookit.favoritemeals.view;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface FavViewInterface {
    void showFavMeals(List<MealModel> meals);
    void RemoveFromFav(MealModel meal);
}
