package com.example.cookit.firebase;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.cookit.model.modelFirebase.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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

    @Override
    public UserModel getUser() {
//        UserModel userModel = null;
//        databaseReference.child("User").child(String.valueOf(id));
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                userModel = snapshot.getValue(UserModel.class);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//        });
//        return userModel;
        return new UserModel();
    }
}