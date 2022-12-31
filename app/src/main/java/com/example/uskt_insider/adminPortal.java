package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class adminPortal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);
        getSupportActionBar().hide();
    }
}