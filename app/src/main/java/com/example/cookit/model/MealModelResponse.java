package com.example.cookit.model;

import java.util.List;

public class MealModelResponse {
    private List<MealModel> mealsModel;

    public MealModelResponse(List<MealModel> mealsModel) {
        this.mealsModel = mealsModel;
    }

    public List<MealModel> getMealsModel() {
        return mealsModel;
    }

    public void setMealsModel(List<MealModel> mealsModel) {
        this.mealsModel = mealsModel;
    }
}
