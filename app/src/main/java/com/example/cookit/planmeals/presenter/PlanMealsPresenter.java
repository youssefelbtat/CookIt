package com.example.cookit.planmeals.presenter;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.RepositoryInterface;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public class PlanMealsPresenter implements PlanPresenterInterface {
    private RepositoryInterface repositoryInterface;

    public PlanMealsPresenter(RepositoryInterface repositoryInterface){
        this.repositoryInterface = repositoryInterface ;
    }

    @Override
    public Single<List<MealModel>> getAllPlanedMeals(String day) {
        System.out.println("Get all planeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+repositoryInterface.getAllStoredPlans(day));
        return repositoryInterface.getAllStoredPlans( day);
    }

    @Override
    public void removeFromPlan(MealModel mealModel) {
        repositoryInterface.removePlan(mealModel);

    }
}
