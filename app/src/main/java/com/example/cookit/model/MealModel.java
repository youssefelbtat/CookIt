package com.example.cookit.model;

public class MealModel {
    String mealName;
    String mealImage;
    String mealDescription;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public MealModel(String mealName, String mealImage) {
        this.mealName = mealName;
        this.mealImage = mealImage;
    }
}
