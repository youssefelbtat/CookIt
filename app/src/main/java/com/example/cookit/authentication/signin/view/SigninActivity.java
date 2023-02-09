package com.example.cookit.authentication.signin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cookit.R;

public class SigninActivity extends AppCompatActivity {

    EditText email_edt,passWord_edt;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

    }

    private void init(){
        email_edt=findViewById(R.id.editTextEmailLogin);
        passWord_edt=findViewById(R.id.editTextPasswordLogin);
        login_btn=findViewById(R.id.btnLogin);
    }
}