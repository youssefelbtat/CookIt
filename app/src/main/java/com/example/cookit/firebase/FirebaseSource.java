package com.example.cookit.firebase;

import android.content.Context;

import com.example.cookit.model.modelFirebase.UserModel;

public class FirebaseSource implements FirebaseSourseInterface{

    private UsersDao usersDao;
    private static FirebaseSource firebaseSource = null;

    private FirebaseSource(Context context){


    }

    public static FirebaseSource getInstance(Context context){

        if(firebaseSource == null){
            firebaseSource = new FirebaseSource(context);
        }
        return firebaseSource;
    }
    @Override
    public void insertUser(UserModel userModel) {

    }

    @Override
    public UserModel getUser() {
        return new UserModel();
    }
}