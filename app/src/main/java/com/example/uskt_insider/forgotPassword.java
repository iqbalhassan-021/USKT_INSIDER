package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {
    EditText usktEmail;
    Button backtoLogin;
    Button ForgetPassword;
    FirebaseAuth forgotPasswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();
        usktEmail = (EditText) findViewById(R.id.usktemail);
        backtoLogin = (Button) findViewById(R.id.loginAgain);
        ForgetPassword = (Button) findViewById(R.id.SendEmail);
        backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtologin = new Intent(forgotPassword.this,AdminDevLogin.class);
                startActivity(backtologin);
            }
        });
        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userinputedEmail = usktEmail.getText().toString();
                if (userinputedEmail.equals("")){
                    usktEmail.setError("Email cannot be empty");
                    usktEmail.requestFocus();
                }

                else {
                    forgotPasswd.sendPasswordResetEmail(userinputedEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(forgotPassword.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(forgotPassword.this, "An error occured while sending the email"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }}
                    });
                }

            }
        });

    }
}

/*     authenticate.sendPasswordResetEmail(userinputedEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(forgotPassword.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(forgotPassword.this, "An error occured while sending the email"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/