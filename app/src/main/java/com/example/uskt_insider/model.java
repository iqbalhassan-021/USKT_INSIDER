package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class model extends AppCompatActivity {
    Spinner flist;
    LinearLayout model;
    Fragment Fragmodel;
    Button choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        getSupportActionBar().hide();
        flist = (Spinner) findViewById(R.id.floorlist);
        String[] floors = {"1st Floor","2nd Floor","3rd Floor","Ground Floor"};
        ArrayAdapter floorspinnerarray = new ArrayAdapter(model.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,floors);
        flist.setAdapter(floorspinnerarray);
        WebView modelview = (WebView) findViewById(R.id.modelinlinerview);
        modelview.getSettings().setJavaScriptEnabled(true);
        modelview.loadUrl("file:///android_asset/model.html");
        model = (LinearLayout) findViewById(R.id.modelcontainer);
        choose = (Button) findViewById(R.id.chooser);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Fragmodel = new modelFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.modelcontainer,Fragmodel);
        transaction.commit();*/
            }
        });

    }
}