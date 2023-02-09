package com.example.cookit.authentication.signup.view;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SignUpViewInterface {

    void onSuccessSignUpWithGoogle();
    void onFailureSignUpWithGoogle(String error);
    void insertUserData(UserModel userModel);

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();
}
