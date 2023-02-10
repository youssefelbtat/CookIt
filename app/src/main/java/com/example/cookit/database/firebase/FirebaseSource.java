package com.example.cookit.database.firebase;

import android.content.Context;
import android.text.BoringLayout;

import com.example.cookit.model.modelFirebase.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class FirebaseSource implements FirebaseSourseInterface {

    private static FirebaseSource firebaseSource = null;
    private DatabaseReference databaseReference;

    private boolean exists =false ;

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
        List<String> route = Arrays.asList(userModel.getEmail().split("\\."));
        databaseReference.child("User").child(route.get(0)).setValue(userModel);

    }

    @Override
    public boolean isUserExists(UserModel userModel) {

        List<String> route = Arrays.asList(userModel.getEmail().split("\\."));
        databaseReference.child("User").child(route.get(0));

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    exists = false;
                }else {
                    exists = true ;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        databaseReference.addListenerForSingleValueEvent(eventListener);

        return exists;
    }

}