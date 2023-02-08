package com.example.cookit.model.modelFirebase;

import androidx.lifecycle.LiveData;

import com.example.cookit.model.MealModel;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public interface RepositoryFirebaseInterface {

    public void SignUpWithGoogle();
    public void signUpWithCreateEmail(UserModel userModel);
    public void removeMealFromFav(MealModel mealModel);
    public void insertMeal(MealModel mealModel);
    public LiveData<List<MealModel>> getFavMealslList();
    public void getAllProducts(NetworkDelegate networkDelegate);



}
