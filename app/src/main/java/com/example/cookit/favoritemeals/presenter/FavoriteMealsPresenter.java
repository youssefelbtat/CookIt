package com.example.cookit.favoritemeals.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.cookit.favoritemeals.view.FavViewInterface;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.RepositoryInterface;

import java.util.List;
public class FavoriteMealsPresenter implements FavPresenterInterface{
    private FavViewInterface _view;
    private RepositoryInterface _repo;
    public FavoriteMealsPresenter(FavViewInterface view, RepositoryInterface repo){
        this._repo=repo;
        this._view=view;

    }

    @Override
    public void getFavMeals(LifecycleOwner lifecycleOwner) {
        _repo.getFavMealslList().observe( lifecycleOwner, new Observer<List<MealModel>>() {
            @Override
            public void onChanged(List<MealModel> products) {
                _view.showFavMeals(products);
            }
        });
    }

    @Override
    public void removeFavMeal(MealModel meal) {
        _repo.removeMealFromFav(meal);
    }
}
