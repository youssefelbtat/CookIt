package com.example.cookit.home.presenter;

import com.example.cookit.model.Category;
import com.example.cookit.model.Country;
import com.example.cookit.model.MealModel;

import java.util.List;

public interface HomePresenter {
    void getRandomMeal();
    void getCountriesList();
    void getCategoriesList();

}
