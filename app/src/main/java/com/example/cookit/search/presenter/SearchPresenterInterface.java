package com.example.cookit.search.presenter;


public interface SearchPresenterInterface {

    public void getAllCategories();

    public void getAllCountries();

    public void getAllIngredient();

    public void getMealsByName(String name);

    public void getMealsByCategories(String category);

    public void getMealsByCountries(String country);

    public void getMealsByIngredients(String ingredient);

}
