package com.example.cookit.favoritemeals.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.cookit.favoritemeals.view.FavViewInterface;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.modelFirebase.RepositoryFirebaseInterface;
import com.example.cookit.model.retrofit.RepositoryInterface;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class FavoriteMealsPresenter implements FavPresenterInterface{
    private RepositoryInterface repositoryInterface;

    public FavoriteMealsPresenter(RepositoryInterface repositoryInterface){
        this.repositoryInterface = repositoryInterface ;
    }


    @Override
    public Single<List<MealModel>> getAllStoredFavorites() {
        return repositoryInterface.getAllStoredFavorites();
    }

    @Override
    public void removeFromFavorite(MealModel mealModel) {
        repositoryInterface.removeFavorite(mealModel);
    }
}
