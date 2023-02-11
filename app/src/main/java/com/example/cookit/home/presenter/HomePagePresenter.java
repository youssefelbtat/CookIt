package com.example.cookit.home.presenter;

import android.widget.Toast;

import com.example.cookit.home.view.HomeViewInterface;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.retrofit.RepositoryInterface;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public class HomePagePresenter implements NetworkDelegate ,HomePresenter {

    HomeViewInterface _view;
    RepositoryInterface _repo;

    public HomePagePresenter(HomeViewInterface view, RepositoryInterface repo){
        this._repo=repo;
        this._view=view;

    }

    @Override
    public void onSuccessMeals(List<MealModel> mealModels) {
            _view.ViewRandomMeal(mealModels);
    }

    @Override
    public void onSuccessCategories(List<Category> categoryList) {
            _view.ViewCategoriesList(categoryList);
    }

    @Override
    public void onSuccessCountries(List<Country> countries) {
        _view.ViewCountriesList(countries);
    }

    @Override
    public void onSuccessIngredients(List<Ingredient> ingredients) {

    }

    @Override
    public void onFailurResult(String message) {
        System.out.println("Error when get data in home : "+message);
    }

    @Override
    public void getRandomMeal() {
            _repo.getRandomMeal(this);
    }

    @Override
    public void getCountriesList() {
            _repo.getAllCountries(this);
    }

    @Override
    public void getCategoriesList() {
        _repo.getAllCategories(this);
    }

    @Override
    public void addToFavorite(MealModel mealModel) {
        _repo.insertFavorite(mealModel);

    }
}
