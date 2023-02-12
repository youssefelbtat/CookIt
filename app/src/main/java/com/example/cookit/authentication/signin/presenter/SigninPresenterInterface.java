package com.example.cookit.authentication.signin.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SigninPresenterInterface {
    void addUserDataToShered(UserModel userModel);
    boolean checkUserData(Context context, String email, String pass);
}
