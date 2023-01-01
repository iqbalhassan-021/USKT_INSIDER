package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText retypepasscode;
    EditText loginString;
    Button signup;
    FirebaseAuth authenticate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        authenticate = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginString = (EditText) findViewById(R.id.loginstring);

        retypepasscode = (EditText) findViewById(R.id.Retypepassword);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString();
                String userPassword = password.getText().toString();
                String userRetype = retypepasscode.getText().toString();
                String LoginString = loginString.getText().toString();
                if(TextUtils.isEmpty(userName)){
                    username.setError("Username cannot be empty");
                    username.requestFocus();
                }
                if(TextUtils.isEmpty(userPassword)){
                    password.setError("Password cannot be empty");
                    password.requestFocus();
                }
                if(LoginString!="uskt@47"){
                    loginString.setError("Invalid entry!");
                    loginString.requestFocus();
                }
                if(userPassword.equals(userRetype)){
                    authenticate.createUserWithEmailAndPassword(userName+"@uskt.edu.pk",userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(signup.this, "User is registered successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(com.example.uskt_insider.signup.this,AdminDevLogin.class));
                            }
                            else{
                                Toast.makeText(signup.this, "User is not registered! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
                else{

                    retypepasscode.setError("Password doesn't match!");
                    retypepasscode.requestFocus();
                }


            }
        });


    }
}