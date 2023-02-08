package com.example.cookit.authentication.signup.presenter;

import com.example.cookit.model.UserModel;

public interface SignUpPresenterInterface {
    void onSuccessSignUpWithGoogle();

    void onFailureSignUpWithGoogle(String error);
}
