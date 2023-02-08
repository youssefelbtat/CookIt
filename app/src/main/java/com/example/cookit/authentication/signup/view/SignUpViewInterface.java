package com.example.cookit.authentication.signup.view;

import com.example.cookit.model.UserModel;

public interface SignUpViewInterface {

    void onSuccessSignUpWithGoogle();

    void onFailureSignUpWithGoogle(String error);
}
