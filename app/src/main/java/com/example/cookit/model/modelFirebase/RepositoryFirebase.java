package com.example.cookit.model.modelFirebase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.cookit.firebase.FirebaseSource;
import com.example.cookit.model.MealModel;
import com.example.cookit.network.NetworkDelegate;

import java.util.List;

public class RepositoryFirebase implements RepositoryFirebaseInterface {

    private Context context;
    private FirebaseSource firebaseSource;

    private static RepositoryFirebase repository = null;

    public RepositoryFirebase(FirebaseSource firebaseSource, Context context) {
        this.context = context;
        this.firebaseSource = firebaseSource;
    }

    public static RepositoryFirebase getInstance(FirebaseSource firebaseSource, Context context){
        if (repository == null){
            repository = new RepositoryFirebase(firebaseSource,context);
        }

        return  repository;
    }

    @Override
    public void SignUpWithGoogle() {

    }

    @Override
    public void signUpWithCreateEmail(UserModel userModel) {
        firebaseSource.insertUser(userModel);
    }

}
