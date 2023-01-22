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

    Button signuppage;
    EditText Username;
    EditText Password;
    EditText userString;
    String concatEmail = "@uskt.edu.pk";
    Button login;
    Button forgotpasswd;

    FirebaseAuth authenticate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dev_login);
        getSupportActionBar().hide();
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        userString = (EditText) findViewById(R.id.loginstring);

        signuppage = (Button) findViewById(R.id.signuppage);
        login = (Button) findViewById(R.id.Login);
       // forgotpasswd = (Button) findViewById(R.id.forgotpasswd);
        authenticate = FirebaseAuth.getInstance();


        signuppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restPasswordPage = new Intent(AdminDevLogin.this, com.example.uskt_insider.signup.class);
                startActivity(restPasswordPage);
            }
        });
       /* forgotpasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restPasswordPage = new Intent(AdminDevLogin.this, forgotPassword.class);
                startActivity(restPasswordPage);
            }
        });*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LoginuserName = Username.getText().toString();
                String LoginuserPassword = Password.getText().toString();
                String userLoginString = userString.getText().toString();

                if(TextUtils.isEmpty(LoginuserName)){
                    Username.setError("Email cannot be empty");
                    Username.requestFocus();
                }
                if(TextUtils.isEmpty(LoginuserPassword)){
                    Password.setError("Password cannot be empty");
                    Password.requestFocus();
                }
                if(LoginuserName.equals("dev@uskt.edu.pk")&&LoginuserPassword.equals("momin47")&&userLoginString.equals("uskt@47")){
                    startActivity(new Intent(com.example.uskt_insider.AdminDevLogin.this,dev_portal.class));
                }
                if (userLoginString.equals("uskt@47")){
                    authenticate.signInWithEmailAndPassword(LoginuserName,LoginuserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                startActivity(new Intent(com.example.uskt_insider.AdminDevLogin.this,adminPortal.class));
                            }
                            else{
                                Toast.makeText(AdminDevLogin.this, "Invalid Entry for admin", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(AdminDevLogin.this, "Invalid Entry", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}