package com.example.cookit.profile.presenter;

import com.example.cookit.model.modelFirebase.UserModel;

public interface profilePresenterInterface {
    UserModel getSavedUserData();
    void updateUserData(UserModel userModel);

    void updateUserFirebaseData(UserModel userModel);

    public void deleteAllMeals() ;

}
