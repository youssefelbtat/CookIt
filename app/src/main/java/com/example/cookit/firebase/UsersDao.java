package com.example.cookit.firebase;

import com.example.cookit.model.modelFirebase.UserModel;

public interface UsersDao {

    void insertUser(UserModel userModel);

    UserModel getUser();
}
