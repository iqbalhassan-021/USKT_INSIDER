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
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newvisitor);
        getSupportActionBar().hide();

        myRef = FirebaseDatabase.getInstance().getReference().child("visitors");

        cnic = (EditText) findViewById(R.id.cnic);
        pnumber = (EditText) findViewById(R.id.phonenumber);
        refby = (EditText) findViewById(R.id.refby);
        city = (EditText) findViewById(R.id.city);
        name = (EditText) findViewById(R.id.fullname);
        saveData = (Button) findViewById(R.id.savedata);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CNIC = cnic.getText().toString();
                String PhoneNumber = pnumber.getText().toString();
                String REFby = refby.getText().toString();
                String CITY = city.getText().toString();
                String NAME = name.getText().toString();
                if(CNIC.equals("")||PhoneNumber.equals("")||REFby.equals("")||CITY.equals("")||NAME.equals("")){
                    Toast.makeText(newvisitor.this, "Please fill all the entries", Toast.LENGTH_SHORT).show();

                }
                else {
                    VisitorClass addnewVisitor = new VisitorClass(NAME,CNIC,PhoneNumber,REFby,CITY);
                    myRef.push().setValue(addnewVisitor);
                    Toast.makeText(newvisitor.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    Intent visitorPage = new Intent(newvisitor.this,visitorpage.class);
                    startActivity(visitorPage);
                }
            }
        });
    }
}