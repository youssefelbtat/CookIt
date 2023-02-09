package com.example.cookit.database.firebase;

import android.content.Context;

import com.example.cookit.model.modelFirebase.UserModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseSource implements FirebaseSourseInterface {

    private static FirebaseSource firebaseSource = null;
    private DatabaseReference databaseReference;

    private FirebaseSource(Context context) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseSource getInstance(Context context) {

        if (firebaseSource == null) {
            firebaseSource = new FirebaseSource(context);
        }
        return firebaseSource;
    }

    @Override
    public void insertUser(UserModel userModel) {

        databaseReference.child("User").child(String.valueOf(userModel.getId())).setValue(userModel);

    }

}