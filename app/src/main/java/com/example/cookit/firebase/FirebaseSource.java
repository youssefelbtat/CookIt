package com.example.cookit.firebase;

import com.example.cookit.model.modelFirebase.UserModel;

public class FirebaseSource implements FirebaseSourseInterface{

    @Override
    public void insertUser(UserModel userModel) {

    }

    @Override
    public UserModel getUser() {
        return new UserModel();
    }
}
