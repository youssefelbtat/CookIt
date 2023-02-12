package com.example.cookit.authentication.signin.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cookit.R;
import com.example.cookit.authentication.signup.view.SignupActivity;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.view.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SigninActivity extends AppCompatActivity {

    EditText email_edt,passWord_edt;
    Button login_btn;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    List<String> usersEmailsList =new ArrayList<>();
    List<String> usersPasswordList =new ArrayList<>();
    String userEmail;
    String []splitEmail;
    String root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        init();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                splitEmail=email_edt.getText().toString().split("\\.");
                root=splitEmail[0];
                userEmail=email_edt.getText().toString();
                if(email_edt.getText().toString().equals("")||email_edt.getText().toString().equals(null)){
                    Toast.makeText(SigninActivity.this, "You should fill all data", Toast.LENGTH_SHORT).show();
                }else if(passWord_edt.getText().toString().equals("")||passWord_edt.getText().toString().equals(null)){
                    Toast.makeText(SigninActivity.this, "You should fill all data", Toast.LENGTH_SHORT).show();
                }else {
                    getAllUsers();

                }
            }
        });

    }

    private void getAllUsers() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel1=snapshot.child(root).getValue(UserModel.class);
                if(userModel1!=null){
                    if(userModel1.getPassWord().equals(passWord_edt.getText().toString())
                            &&userModel1.getEmail().equals(userEmail)){
                        System.out.println("Successed");

                        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        System.out.println("Data is invalid");
                        Toast.makeText(SigninActivity.this, "Data invalid.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    System.out.println("Data is invalid");
                    Toast.makeText(SigninActivity.this, "Data invalid.", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Data is invalid");
                Toast.makeText(SigninActivity.this, "Data invalid.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init(){
        email_edt=findViewById(R.id.editTextEmailLogin);
        passWord_edt=findViewById(R.id.editTextPasswordLogin);
        login_btn=findViewById(R.id.btnLogin);
    }
}