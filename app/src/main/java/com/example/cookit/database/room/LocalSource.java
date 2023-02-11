package com.example.cookit.database.room;


import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.cookit.model.MealModel;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface LocalSource {

    void insertFavorite(MealModel mealModel);
    void removeFavorite(MealModel mealModel);
    Single<List<MealModel>> getAllStoredFavorites();
    void insertPlan(MealModel mealModel);
    void removePlan(MealModel mealModel);
    Single<List<MealModel>> getAllStoredPlans(String day);
}
