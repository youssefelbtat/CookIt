package com.example.cookit.database.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cookit.model.MealModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface MealDao {
    @Query("SELECT * From Meals where isFavorite = '1'")
    Single<List<MealModel>> getFavorites() ;
    @Insert
    void insertFavorite (MealModel mealModel);
    @Delete
    void deleteFavorite (MealModel mealModel);
    @Query("SELECT * From Meals where nameDay !='Not'")
    Single<List<MealModel>> getPlans() ;
    @Insert
    void insertPlan (MealModel mealModel);
    @Delete
    void deletePlan (MealModel mealModel);
    @Query("DELETE FROM Meals")
    public void deleteAllMeals() ;

}
