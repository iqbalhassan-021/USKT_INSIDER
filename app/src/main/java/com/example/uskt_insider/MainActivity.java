package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button newVisitor;
    Button userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        newVisitor = (Button) findViewById(R.id.newvisitor);
        userLogin = (Button) findViewById(R.id.loginpage);
        newVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visitorPage = new Intent(MainActivity.this,newvisitor.class);
                startActivity(visitorPage);
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginPage = new Intent(MainActivity.this,AdminDevLogin.class);
                startActivity(loginPage);
            }
        });
    }
}