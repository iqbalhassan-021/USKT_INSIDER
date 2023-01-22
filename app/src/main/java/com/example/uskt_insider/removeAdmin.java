package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class removeAdmin extends AppCompatActivity {
    WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_admin);
        getSupportActionBar().hide();
        mywebview = (WebView) findViewById(R.id.remweb);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("https://console.firebase.google.com/u/0/project/uskt-insider/authentication/users");
    }
}