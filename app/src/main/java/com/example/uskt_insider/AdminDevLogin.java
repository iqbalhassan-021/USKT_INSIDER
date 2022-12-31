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

public class AdminDevLogin extends AppCompatActivity {
    Button forgotPassword;
    Button signuppage;
    EditText Username;
    EditText Password;

    Button login;

    FirebaseAuth authenticate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dev_login);
        getSupportActionBar().hide();
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);

        forgotPassword = (Button) findViewById(R.id.forgotpassword);
        signuppage = (Button) findViewById(R.id.signuppage);
        login = (Button) findViewById(R.id.Login);
        authenticate = FirebaseAuth.getInstance();
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restPasswordPage = new Intent(AdminDevLogin.this, com.example.uskt_insider.forgotPassword.class);
                startActivity(restPasswordPage);
            }
        });

        signuppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restPasswordPage = new Intent(AdminDevLogin.this, com.example.uskt_insider.signup.class);
                startActivity(restPasswordPage);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LoginuserName = Username.getText().toString();
                String LoginuserPassword = Password.getText().toString();

                if(TextUtils.isEmpty(LoginuserName)){
                    Username.setError("Username cannot be empty");
                    Username.requestFocus();
                }
                if(TextUtils.isEmpty(LoginuserPassword)){
                    Password.setError("Password cannot be empty");
                    Password.requestFocus();
                }
                else{
                    authenticate.signInWithEmailAndPassword(LoginuserName+"@uskt.edu.pk",LoginuserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(AdminDevLogin.this, "User is registered successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(com.example.uskt_insider.AdminDevLogin.this,adminPortal.class));
                            }
                            else{
                                Toast.makeText(AdminDevLogin.this, "User is not registered! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });
    }
}