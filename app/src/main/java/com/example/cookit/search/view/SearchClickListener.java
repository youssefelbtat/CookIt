package com.example.cookit.search.view;


import com.example.cookit.model.MealModel;

public interface SearchClickListener {

    void categoryItemOnClick(String category);
    void countryItemOnClick(String country);
    void ingredientItemOnclick(String ingredient);
    void categoryOnClick();
    void countryOnClick();
    void ingredientOnclick();

    void addToFavoriteOnClick(MealModel mealModel);


}
