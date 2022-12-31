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

public class newvisitor extends AppCompatActivity {
    EditText cnic;
    EditText pnumber;
    EditText refby;
    EditText city;
    EditText name;
    Button saveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newvisitor);
        getSupportActionBar().hide();
        FirebaseDatabase adminsignup = FirebaseDatabase.getInstance("https://uskt-insider-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = adminsignup.getReference();

        cnic = (EditText) findViewById(R.id.cnic);
        pnumber = (EditText) findViewById(R.id.phonenumber);
        refby = (EditText) findViewById(R.id.refby);
        city = (EditText) findViewById(R.id.city);
        name = (EditText) findViewById(R.id.fullname);
        saveData = (Button) findViewById(R.id.savedata);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cnic.getText().toString().equals("")||pnumber.getText().toString().equals("")||refby.getText().toString().equals("")||city.getText().toString().equals("")||name.getText().toString().equals("")){
                    Toast.makeText(newvisitor.this, "Please fill all the entries", Toast.LENGTH_SHORT).show();

                }
                else {
                    myRef.child("visitor").child("name").setValue(name.getText().toString());
                    myRef.child("visitor").child("number").setValue(name.getText().toString());
                    myRef.child("visitor").child("cnic").setValue(cnic.getText().toString());
                    myRef.child("visitor").child("city").setValue(city.getText().toString());
                    myRef.child("visitor").child("referedby").setValue(refby.getText().toString());
                    Intent visitorPage = new Intent(newvisitor.this,visitorpage.class);
                    startActivity(visitorPage);
                }
            }
        });
    }
}