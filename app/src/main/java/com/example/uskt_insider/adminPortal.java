package com.example.uskt_insider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class adminPortal extends AppCompatActivity {
    Button newVisitorsinUSKT;
    Button view_MOdel;
    Button view_Feedbacks;
    Button sendRequest;
    Button logout;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);
        getSupportActionBar().hide();
        newVisitorsinUSKT = (Button) findViewById(R.id.checknewVisitors);
        view_MOdel = (Button) findViewById(R.id.viewModel);
        view_Feedbacks = (Button) findViewById(R.id.checkFeeds);
        sendRequest = (Button) findViewById(R.id.sendrequests);
        logout = (Button) findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();
        newVisitorsinUSKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadnewvisitors = new Intent(adminPortal.this,newVisitors.class);
                startActivity(loadnewvisitors);
            }
        });
        view_MOdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadModel = new Intent(adminPortal.this,model.class);
                startActivity(loadModel);
            }
        });
        view_Feedbacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadFeeds = new Intent(adminPortal.this,viewFeedbacks.class);
                startActivity(loadFeeds);
            }
        });
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadRequestpage = new Intent(adminPortal.this,send_request.class);
                startActivity(loadRequestpage);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(adminPortal.this, "Logout successfull", Toast.LENGTH_SHORT).show();
                Intent loginpage = new Intent(adminPortal.this,AdminDevLogin.class);
                startActivity(loginpage);


            }
        });

    }
}