package com.example.cookit.search.presenter;

import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Ingredient;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.RepositoryInterface;
import com.example.cookit.network.NetworkDelegate;
import com.example.cookit.search.view.SearchViewInterface;

import java.util.List;

public class SearchPresenter implements SearchPresenterInterface , NetworkDelegate {

    private SearchViewInterface searchViewInterface;
    private RepositoryInterface repositoryInterface;


    public SearchPresenter(SearchViewInterface searchViewInterface, RepositoryInterface repositoryInterface ) {
        this.searchViewInterface = searchViewInterface;
        this.repositoryInterface = repositoryInterface;
    }


    @Override
    public void onSuccessMeals(List<MealModel> mealModels) {
        searchViewInterface.getMeals(mealModels);
    }

    @Override
    public void onSuccessCategories(List<Category> categoryList) {
        searchViewInterface.getAllCategories(categoryList);
    }

    @Override
    public void onSuccessCountries(List<Country> countries) {
        searchViewInterface.getAllCountries(countries);
    }

    @Override
    public void onSuccessIngredients(List<Ingredient> ingredients) {
        searchViewInterface.getAllIngredient(ingredients);
    }

    @Override
    public void onFailurResult(String message) {

    }

    @Override
    public void getAllCategories() {
        repositoryInterface.getAllCategories(this);
    }

    @Override
    public void getAllCountries() {
        repositoryInterface.getAllCountries(this);
    }

    @Override
    public void getAllIngredient() {
        repositoryInterface.getAllIngredient(this);
    }

    @Override
    public void getMealsByName(String name) {
        repositoryInterface.getMealsByFirstChar(this,name);
    }

    @Override
    public void getMealsByCategories(String category) {
        repositoryInterface.getMealsByCategories(this,category);
    }

    @Override
    public void getMealsByCountries(String country) {
        repositoryInterface.getMealsByCountries(this,country);
    }

    @Override
    public void getMealsByIngredients(String ingredient) {
        repositoryInterface.getMealsByIngredients(this,ingredient);
    }
}
