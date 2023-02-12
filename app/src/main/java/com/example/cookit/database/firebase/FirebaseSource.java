package com.example.cookit.database.firebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.BoringLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cookit.authentication.signin.view.SigninActivity;
import com.example.cookit.database.sharedpreference.SharedPreferenceSource;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.view.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class FirebaseSource implements FirebaseSourseInterface  {

    private static FirebaseSource firebaseSource = null;
    private DatabaseReference databaseReference;

    private boolean exists =false ;
    private boolean  isSucced=false;

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

    @Override
    public boolean isLoginSuccessed(Context context,String email, String pass) {
        String[]splitEmail=email.split("\\.");
        String root=splitEmail[0];

        DatabaseReference databaseReference1 =FirebaseDatabase.getInstance()
                .getReference("User");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                UserModel userModel1=snapshot.child(root).getValue(UserModel.class);
                if(userModel1!=null){
                    if(userModel1.getPassWord().equals(pass)
                            &&userModel1.getEmail().equals(email)){
                        isSucced = true;
                        SharedPreferenceSource.getInstance(context).saveUserData(userModel1);
                        System.out.println("Successed");

                    }else {
                        isSucced=false;
                    }
                }else {
                    System.out.println("Data is invalid elssssss");
                    isSucced=false;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Data is invalid OnCancelled");
                isSucced=false;
            }
        });
        return isSucced;
    }


}