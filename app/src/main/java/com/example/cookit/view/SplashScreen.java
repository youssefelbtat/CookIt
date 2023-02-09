package com.example.cookit.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.cookit.R;
import com.example.cookit.authentication.signup.view.SignupActivity;
import com.example.cookit.utalites.Utalites;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(Utalites.SHARDPREFERENCE,getApplicationContext().MODE_PRIVATE);
                if(sharedPreferences.getString(Utalites.EMAIL,null) == null) {
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