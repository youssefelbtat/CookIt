package com.example.cookit.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.cookit.R;
import com.example.cookit.authentication.signup.view.SignupActivity;
import com.example.cookit.model.modelFirebase.User;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(User.SHARDPREFERENCE,getApplicationContext().MODE_PRIVATE);
                if(sharedPreferences.getString(User.EMAIL,null) == null) {
                    Intent intent = new Intent(SplashScreen.this, SignupActivity.class);
                    startActivity(intent);
                }else{
                    System.out.println(sharedPreferences.getString(User.EMAIL,null));
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },6000);
    }
}