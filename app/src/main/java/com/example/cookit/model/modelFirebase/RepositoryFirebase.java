package com.example.cookit.model.modelFirebase;

import android.app.Activity;
import android.content.Context;

import com.example.cookit.database.firebase.FirebaseSource;
import com.example.cookit.database.sharedpreference.SharedPreferenceSource;

public class RepositoryFirebase implements RepositoryFirebaseInterface {

    private Context context;
    private FirebaseSource firebaseSource;

    private SharedPreferenceSource sharedPreferenceSource;

    private static RepositoryFirebase repository = null;

    public RepositoryFirebase(FirebaseSource firebaseSource,SharedPreferenceSource sharedPreferenceSource, Context context) {
        this.context = context;
        this.firebaseSource = firebaseSource;
        this.sharedPreferenceSource = sharedPreferenceSource ;
    }

    public static RepositoryFirebase getInstance(FirebaseSource firebaseSource,SharedPreferenceSource sharedPreferenceSource, Context context){
        if (repository == null){
            repository = new RepositoryFirebase(firebaseSource,sharedPreferenceSource,context);
        }

        return  repository;
    }

    @Override
    public void SignUpWithGoogle(Activity activity, UserModel userModel) {
        firebaseSource.insertUser(userModel);
    }

    @Override
    public void signUpWithCreateEmail(UserModel userModel) {
        firebaseSource.insertUser(userModel);
    }

    @Override
    public void saveUserData(UserModel userModel) {
        sharedPreferenceSource.saveUserData(userModel);
    }

    @Override
    public UserModel getSavedUserData() {
        return null;
    }

}
