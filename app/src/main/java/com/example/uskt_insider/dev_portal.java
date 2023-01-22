package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dev_portal extends AppCompatActivity {
    Button checkRequests;
    Button AddRemoveAdmin;
    Button logout;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_portal);
        getSupportActionBar().hide();
        logout = (Button) findViewById(R.id.logout);
        checkRequests = (Button) findViewById(R.id.checkrequests);
        AddRemoveAdmin = (Button) findViewById(R.id.addremoveadmion);

        AddRemoveAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rmadmin = new Intent(dev_portal.this,removeAdmin.class);
                startActivity(rmadmin);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(dev_portal.this, "Logout successfull", Toast.LENGTH_SHORT).show();
                Intent loginpage = new Intent(dev_portal.this,AdminDevLogin.class);
                startActivity(loginpage);


            }
        });
        checkRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent newIntent = new Intent(dev_portal.this,view_requests.class);
               startActivity(newIntent);
            }
        });
    }
}