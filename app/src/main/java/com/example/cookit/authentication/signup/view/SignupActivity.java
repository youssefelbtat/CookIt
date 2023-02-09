package com.example.cookit.authentication.signup.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookit.R;
import com.example.cookit.authentication.signin.view.SigninActivity;
import com.example.cookit.authentication.signup.presenter.SignUpPresenterInterface;
import com.example.cookit.authentication.signup.presenter.SignupPresenter;
import com.example.cookit.firebase.FirebaseSource;
import com.example.cookit.model.modelFirebase.RepositoryFirebase;
import com.example.cookit.model.modelFirebase.User;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.view.MainActivity;

public class SignupActivity extends AppCompatActivity implements SignUpViewInterface,SignUpOnclickListener{

    TextView skip , login ;
    EditText userName , email ,password ,confirmPassword;
    Button signup ;

    public static int id =12 ;

    private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
    SignUpPresenterInterface signUpPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();


        signUpPresenterInterface = new SignupPresenter(RepositoryFirebase.getInstance(FirebaseSource.getInstance(getApplicationContext())
                ,getApplicationContext()));


        login.setOnClickListener(event -> loginOnClick());
        skip.setOnClickListener(event -> skipOnClick());
        signup.setOnClickListener(event -> signupWithCreateEmailClick());


    }

    public void init(){
        skip = findViewById(R.id.skip);
        login = findViewById(R.id.textLogin);
        userName = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
        signup = findViewById(R.id.btnSignup);
    }

    @Override
    public void onSuccessSignUpWithGoogle() {

    }

    @Override
    public void onFailureSignUpWithGoogle(String error) {

    }

    @Override
    public void insertUserData(UserModel userModel) {
        signUpPresenterInterface.addUserData(userModel);
    }

    @Override
    public void signUpWithGoogleClick() {

    }

    @Override
    public void signupWithCreateEmailClick() {

        if(userName.getText().toString().equals("")){
            Toast.makeText(this, "You should fill all data", Toast.LENGTH_SHORT).show();
        }else if(email.getText().toString().equals("")){
            Toast.makeText(this, "You should fill all data", Toast.LENGTH_SHORT).show();
        }else if(password.getText().toString().equals("")){
            Toast.makeText(this, "You should fill all data", Toast.LENGTH_SHORT).show();
        }else if(confirmPassword.getText().toString().equals("")){
            Toast.makeText(this, "You should fill all data", Toast.LENGTH_SHORT).show();
        }else if (!password.getText().toString().equals(confirmPassword.getText().toString())){
            Toast.makeText(this, "Password and confirmPasssword don’t match", Toast.LENGTH_SHORT).show();
        }else if (!email.getText().toString().matches(EMAIL)){
            Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show();
        }else if (!password.getText().toString().matches(PASSWORD)){
            Toast.makeText(this, "Password is invalid", Toast.LENGTH_SHORT).show();
        } else {
            UserModel userModel = new UserModel();
            userModel.setId(id);
            userModel.setUserName(userName.getText().toString());
            userModel.setEmail(email.getText().toString());
            userModel.setPassWord(password.getText().toString());
            id++;
            insertUserData(userModel);

            SharedPreferences sharedPreferences = getSharedPreferences(User.SHARDPREFERENCE,getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(String.valueOf(User.ID),id);
            editor.putString(User.USERNAME,userModel.getUserName());
            editor.putString(User.EMAIL,userModel.getEmail());
            editor.putString(User.PASSWORD,userModel.getPassWord());
            editor.commit();

            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "You registered successfully", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void loginOnClick() {
        Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
        startActivity(intent);
    }

    @Override
    public void skipOnClick() {
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);
    }


}