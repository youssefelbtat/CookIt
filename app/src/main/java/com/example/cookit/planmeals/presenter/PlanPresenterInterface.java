package com.example.cookit.planmeals.presenter;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.modelFirebase.UserModel;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface PlanPresenterInterface {
    Single<List<MealModel>> getAllPlanedMeals(String day);
    void removeFromPlan(MealModel mealModel);
    void uploadPlanInFirebase(UserModel userModel);

    UserModel getSavedData();

    public void addToFavorite(MealModel mealModel);
}
