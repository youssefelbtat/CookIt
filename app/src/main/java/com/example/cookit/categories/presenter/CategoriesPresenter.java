package com.example.cookit.categories.presenter;

import com.example.cookit.categories.view.CategoriesViewInterface;
import com.example.cookit.countries.presenter.CountriesPresenterInterface;
import com.example.cookit.countries.view.CountriesViewInterface;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.retrofit.RepositoryInterface;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public class CategoriesPresenter implements CategoriesPresenterInterface, NetworkDelegate {
    CategoriesViewInterface _view;
    RepositoryInterface _repo;
    public CategoriesPresenter(CategoriesViewInterface view, RepositoryInterface repo){
        this._repo=repo;
        this._view=view;

    }

    @Override
    public void getMeals(String category) {
        _repo.getMealsByCategories(this,category);
    }

    @Override
    public void addToFavorite(MealModel mealModel) {
        _repo.insertFavorite(mealModel);

    }

    @Override
    public void onSuccessMeals(List<MealModel> mealModels) {
        _view.ViewCategoriesMeal(mealModels);
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
