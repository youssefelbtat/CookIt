package com.example.cookit.favoritemeals.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.cookit.model.MealModel;

import java.util.List;

public interface FavPresenterInterface {
    void getFavMeals(LifecycleOwner lifecycleOwner);
    void removeFavMeal(MealModel meal);
}
