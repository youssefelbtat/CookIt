package com.example.cookit.database.sharedpreference;

import androidx.room.Update;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SharedPreferenceSourceInterfece {

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();

    void updateUserData(UserModel userModel);



}
