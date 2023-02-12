package com.example.cookit.authentication.signin.view;

import android.content.Context;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SignInViewInterface {
    void onLoginSuccess(UserModel userModel);
    boolean isSuccessed(Context context, String email, String pass);
}
