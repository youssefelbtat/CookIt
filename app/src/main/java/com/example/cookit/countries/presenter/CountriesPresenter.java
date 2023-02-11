package com.example.cookit.countries.presenter;

import com.example.cookit.countries.view.CountriesViewInterface;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.retrofit.RepositoryInterface;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public class CountriesPresenter implements CountriesPresenterInterface,NetworkDelegate {
    CountriesViewInterface _view;
    RepositoryInterface _repo;
    public CountriesPresenter(CountriesViewInterface view, RepositoryInterface repo){
        this._repo=repo;
        this._view=view;

    }
    @Override
    public void getMeals(String countryName) {
            _repo.getMealsByCountries(this,countryName);
    }

    @Override
    public void addToFavorite(MealModel mealModel) {
        _repo.insertFavorite(mealModel);

    }

    @Override
    public void onSuccessMeals(List<MealModel> mealModels) {
        _view.ViewCounteryMeal(mealModels);
    }

    @Override
    public void onSuccessCategories(List<Category> categoryList) {

    }

    @Override
    public void onSuccessCountries(List<Country> countries) {


    }

    @Override
    public void onSuccessIngredients(List<Ingredient> ingredients) {

    }

    @Override
    public void onFailurResult(String message) {

    }
}
