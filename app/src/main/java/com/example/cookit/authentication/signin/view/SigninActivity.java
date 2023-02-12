package com.example.cookit.authentication.signin.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cookit.R;
import com.example.cookit.authentication.signin.presenter.SigninPresenter;
import com.example.cookit.authentication.signin.presenter.SigninPresenterInterface;
import com.example.cookit.database.firebase.FirebaseSource;
import com.example.cookit.database.sharedpreference.SharedPreferenceSource;
import com.example.cookit.model.modelFirebase.RepositoryFirebase;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.utalites.Utalites;
import com.example.cookit.view.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SigninActivity extends AppCompatActivity implements SigninOnclickListener,SignInViewInterface {

    EditText email_edt,passWord_edt;
    Button login_btn;
    SigninPresenterInterface signinPresenterInterface;

    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        init();
        signinPresenterInterface=new SigninPresenter(this, RepositoryFirebase.getInstance(FirebaseSource.getInstance(this)
                , SharedPreferenceSource.getInstance(this),this));

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail=email_edt.getText().toString();
                if(email_edt.getText().toString().equals("")||email_edt.getText().toString().equals(null)){
                    Toast.makeText(SigninActivity.this, "You should fill all data", Toast.LENGTH_SHORT).show();
                }else if(passWord_edt.getText().toString().equals("")||passWord_edt.getText().toString().equals(null)){
                    Toast.makeText(SigninActivity.this, "You should fill all data", Toast.LENGTH_SHORT).show();
                }else {
                    onLoginClicked();
                }
            }
        });

    }


    private void init(){
        email_edt=findViewById(R.id.editTextEmailLogin);
        passWord_edt=findViewById(R.id.editTextPasswordLogin);
        login_btn=findViewById(R.id.btnLogin);
    }


    @Override
    public void onLoginSuccess(UserModel userModel) {
        signinPresenterInterface.addUserDataToShered(userModel);
    }

    @Override
    public boolean isSuccessed(Context context, String email, String pass) {
        return signinPresenterInterface.checkUserData(context,email,pass);
    }

    @Override
    public void onLoginClicked() {
        if(isSuccessed(getApplicationContext(),email_edt.getText().toString(),passWord_edt.getText().toString())){
            Toast.makeText(SigninActivity.this, "Login Succeed.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(SigninActivity.this, "Data invalid.", Toast.LENGTH_SHORT).show();
        }
    }
}