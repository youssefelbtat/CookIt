package com.example.cookit.model.modelFirebase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.cookit.firebase.FirebaseSource;
import com.example.cookit.model.MealModel;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public class RepositoryFirebase implements RepositoryFirebaseInterface {

    private Context context;
    private FirebaseSource firebaseSource;

    private static RepositoryFirebase repository = null;

    public RepositoryFirebase(FirebaseSource firebaseSource, Context context) {
        this.context = context;
        this.firebaseSource = firebaseSource;
    }

    public static RepositoryFirebase getInstance(FirebaseSource firebaseSource, Context context){
        if (repository == null){
            repository = new RepositoryFirebase(firebaseSource,context);
        }

        return  repository;
    }

    @Override
    public void SignUpWithGoogle() {

    }

    @Override
    public void signUpWithCreateEmail(UserModel userModel) {

    }

    @Override
    public void removeMealFromFav(MealModel mealModel) {

    }

    @Override
    public void insertMeal(MealModel mealModel) {

    }

    @Override
    public LiveData<List<MealModel>> getFavMealslList() {
        return null;
    }

    @Override
    public void getAllProducts(NetworkDelegate networkDelegate) {

    }
}
