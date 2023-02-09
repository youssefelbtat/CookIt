package com.example.cookit.database.sharedpreference;

import com.example.cookit.model.modelFirebase.UserModel;

public interface SharedPreferenceSourceInterfece {

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();
}
