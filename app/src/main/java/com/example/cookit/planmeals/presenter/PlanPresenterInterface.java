package com.example.cookit.planmeals.presenter;

import com.example.cookit.model.MealModel;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface PlanPresenterInterface {
    Single<List<MealModel>> getAllPlanedMeals(String day);
    void removeFromPlan(MealModel mealModel);
}
