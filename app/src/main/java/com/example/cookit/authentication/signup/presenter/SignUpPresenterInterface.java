package com.example.cookit.authentication.signup.presenter;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SignUpPresenterInterface {
    void onSuccessSignUpWithGoogle();
    void onFailureSignUpWithGoogle(String error);

    void addUserData(UserModel userModel) ;

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();

}
