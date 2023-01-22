package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class visitorpage extends AppCompatActivity {
    Button LoadMap;
    Button Load3Dmodel;
    Button LoadFeedbackPAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitorpage);
        getSupportActionBar().hide();
        Load3Dmodel = (Button) findViewById(R.id.loadmodelvisitor);
        LoadFeedbackPAge = (Button) findViewById(R.id.feedbackpage);
        Load3Dmodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modelcontainerclass = new Intent(visitorpage.this,model.class);
                startActivity(modelcontainerclass);
            }
        });
        LoadFeedbackPAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent givequickfeedback = new Intent(visitorpage.this,givefeedback.class);
                startActivity(givequickfeedback);
            }
        });


    }
}