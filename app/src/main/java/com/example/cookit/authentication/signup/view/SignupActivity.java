package com.example.cookit.authentication.signup.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookit.R;
import com.example.cookit.authentication.signin.view.SigninActivity;
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
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignupActivity extends AppCompatActivity {

    private int RC_SIGN_IN=1;

    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    ImageButton signupWithGoogle_btn;

    TextView skip , login ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupWithGoogle_btn=findViewById(R.id.google_img_btn);
        firebaseAuth=FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient= GoogleSignIn.getClient(this,googleSignInOptions);
        signupWithGoogle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        skip = findViewById(R.id.skip);
        login = findViewById(R.id.textLogin);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
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
                        System.out.println("ss to signup: "+ user.getEmail().toString()+"The name is : "+user.getDisplayName());
                        Toast.makeText(SignupActivity.this, "The Email is : "+user.getEmail()+"The name is : "+user.getDisplayName(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    System.out.println("Filed to signup");
                    Toast.makeText(SignupActivity.this, " Filed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}