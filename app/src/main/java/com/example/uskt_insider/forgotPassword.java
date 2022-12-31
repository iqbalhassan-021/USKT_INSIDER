package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class forgotPassword extends AppCompatActivity {
    Button savepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();
        savepassword = (Button) findViewById(R.id.savedata);
        savepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackToLoginPage = new Intent(forgotPassword.this,AdminDevLogin.class);
                startActivity(BackToLoginPage);
            }
        });
    }
}