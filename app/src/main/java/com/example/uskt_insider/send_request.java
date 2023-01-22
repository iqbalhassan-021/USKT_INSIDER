package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class send_request extends AppCompatActivity {
    EditText request_Title;
    EditText actualRequest;
    Button Submit;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_request);
        getSupportActionBar().hide();
        request_Title = (EditText) findViewById(R.id.requesttitle);
        actualRequest = (EditText) findViewById(R.id.theRequest);
        Submit = (Button) findViewById(R.id.submitfeedback);
        myRef = FirebaseDatabase.getInstance().getReference().child("Requests");
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _requesttitle = request_Title.getText().toString();
                String _theRequest = actualRequest.getText().toString();
                if(_requesttitle.equals("")||_theRequest.equals("")){
                    Toast.makeText(send_request.this, "Please fill all the entries", Toast.LENGTH_SHORT).show();
                }
                else{
                    SendRequestClass newRequest = new SendRequestClass(_requesttitle,_theRequest);
                    myRef.push().setValue(newRequest);
                    Toast.makeText(send_request.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
                    Intent AdminPage = new Intent(send_request.this,adminPortal.class);
                    startActivity(AdminPage);
                }
            }
        });
    }
}