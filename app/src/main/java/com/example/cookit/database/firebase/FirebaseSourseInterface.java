package com.example.cookit.database.firebase;

import com.example.cookit.model.modelFirebase.UserModel;

public interface FirebaseSourseInterface {

    void insertUser(UserModel userModel);
    boolean isUserExists(UserModel userModel);


}
