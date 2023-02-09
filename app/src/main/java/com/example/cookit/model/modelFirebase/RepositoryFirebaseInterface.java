package com.example.cookit.model.modelFirebase;

import androidx.lifecycle.LiveData;

import com.example.cookit.model.MealModel;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public interface RepositoryFirebaseInterface {

    public void SignUpWithGoogle(UserModel userModel);
    public void signUpWithCreateEmail(UserModel userModel);

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();

}
