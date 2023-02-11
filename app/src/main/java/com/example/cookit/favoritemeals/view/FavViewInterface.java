package com.example.cookit.favoritemeals.view;

import com.example.cookit.model.MealModel;
import com.example.cookit.model.modelFirebase.UserModel;

import java.util.List;

public interface FavViewInterface {
    void removeFromFav(MealModel meal);

    public void showData(List<MealModel> products);

    public void updateFavoriteInFirebase(UserModel userModel);

}
