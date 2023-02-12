package com.example.cookit.database.firebase;

import android.app.Activity;
import android.content.Context;

import com.example.cookit.model.modelFirebase.UserModel;

public interface FirebaseSourseInterface {

    void insertUser(UserModel userModel);
    boolean isUserExists(UserModel userModel);

    boolean isLoginSuccessed(Context context, String email, String pass);



}
