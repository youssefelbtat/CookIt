package com.example.cookit.authentication.signup.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookit.R;
import com.example.cookit.authentication.signin.view.SigninActivity;
import com.example.cookit.authentication.signup.presenter.SignUpPresenterInterface;
import com.example.cookit.authentication.signup.presenter.SignupPresenter;
import com.example.cookit.database.firebase.FirebaseSource;
import com.example.cookit.database.sharedpreference.SharedPreferenceSource;
import com.example.cookit.model.modelFirebase.RepositoryFirebase;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.utalites.Utalites;
import com.example.cookit.view.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.annotations.Nullable;

public class SignupActivity extends AppCompatActivity implements SignUpViewInterface,SignUpOnclickListener{

    private int RC_SIGN_IN=1;

    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    ImageButton signupWithGoogle_btn;

    TextView skip , login ;
    EditText userName , email ,password ,confirmPassword;
    Button signup ;

    SignUpPresenterInterface signUpPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupWithGoogle_btn=findViewById(R.id.google_img_btn);
        getSupportActionBar().hide();
        init();
        initgoogle();

        signupWithGoogle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        signUpPresenterInterface = new SignupPresenter(RepositoryFirebase.getInstance(FirebaseSource.getInstance(this)
                , SharedPreferenceSource.getInstance(this),this));


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
    public boolean isUserExists(UserModel userModel) {
        return signUpPresenterInterface.isUserExists(userModel);
    }

    @Override
    public void saveUserData(UserModel userModel) {
        signUpPresenterInterface.saveUserData(userModel);
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
            Toast.makeText(this, "Password and confirmPassword don’t match", Toast.LENGTH_SHORT).show();
        }else if (!email.getText().toString().matches(Utalites.EMAIL_PATTERN)){
            Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show();
        }else if (!password.getText().toString().matches(Utalites.PASSWORD_PATTERN)){
            Toast.makeText(this, "Password is invalid", Toast.LENGTH_SHORT).show();
        } else {
            UserModel userModel = new UserModel();
            userModel.setUserName(userName.getText().toString());
            userModel.setEmail(email.getText().toString());
            userModel.setPassWord(password.getText().toString());
            userModel.setFavorites(null);

            if (isUserExists(userModel)){

                insertUserData(userModel);
                saveUserData(userModel);

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                Utalites.SKIP = null;
                finish();
                Toast.makeText(this, "You registered successfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "This email already exists", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public void loginOnClick() {
        Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
        startActivity(intent);
    }

    @Override
    public void skipOnClick() {
        Utalites.SKIP = "skip";
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void signup(){
        Intent signupIntent =googleSignInClient.getSignInIntent();
        startActivityForResult(signupIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }
    private void initgoogle(){
        firebaseAuth=FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken((getString(R.string.default_web_client_id)))
                .requestEmail()
                .build();

        googleSignInClient= GoogleSignIn.getClient(this,googleSignInOptions);
        googleSignInClient.revokeAccess();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        System.out.println("Hello from handleSignInResult Auth........");
        try{
            GoogleSignInAccount acc=completedTask.getResult(ApiException.class);
            System.out.println("SignIn Successfully.......");
            Toast.makeText(this, "SignIn Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);

        }catch (ApiException exception){
            exception.printStackTrace();
            System.out.println("SignIn SignIn Filed: ");
            Toast.makeText(getApplicationContext(), "SignIn Filed", Toast.LENGTH_SHORT).show();

        }
    }
    private void FirebaseGoogleAuth(GoogleSignInAccount account){
        System.out.println("Hello from FirebaseGoogle Auth........");
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignupActivity.this, " Successfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser user=firebaseAuth.getCurrentUser();
                    if(user!=null){

                        UserModel userModel = new UserModel();
                        userModel.setUserName(user.getDisplayName());
                        userModel.setEmail(user.getEmail());
                        userModel.setImage(user.getPhotoUrl().toString());
                        userModel.setFavorites(null);
                        saveUserData(userModel);
                        System.out.println("ss to signup: "+ userModel.getEmail().toString()+"The name is : "+user.getDisplayName()+userModel.getImage());
                        Toast.makeText(SignupActivity.this, "Signed Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    System.out.println("Filed to signup");
                    Toast.makeText(SignupActivity.this, " Filed", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }




}