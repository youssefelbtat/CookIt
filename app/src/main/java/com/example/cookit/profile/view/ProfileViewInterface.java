package com.example.cookit.profile.view;

import com.example.cookit.model.modelFirebase.UserModel;

import java.util.List;

public interface ProfileViewInterface {

    UserModel getSavedUserData();

    public void showData(UserModel userModel);
}
