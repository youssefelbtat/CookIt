package com.example.cookit.authentication.signup.view;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SignUpOnclickListener {

    void signUpWithGoogleClick();

    void signupWithCreateEmailClick();

    void loginOnClick();

    void skipOnClick();
}
