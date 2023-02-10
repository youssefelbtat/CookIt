package com.example.cookit.model;

import java.util.List;

public class MealModelResponse {
    private List<MealModel> meals;

    public MealModelResponse(List<MealModel> mealsModel) {
        this.meals = mealsModel;
    }

    public List<MealModel> getMealsModel() {
        return meals;
    }

    public void setMealsModel(List<MealModel> mealsModel) {
        this.meals = mealsModel;
    }
}
