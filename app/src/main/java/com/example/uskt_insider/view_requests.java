package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class view_requests extends AppCompatActivity {


    int i = 0;
    ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedbacks);
        getSupportActionBar().hide();

        myListview = (ListView) findViewById(R.id.userlist);
        final ArrayList<String> list = new ArrayList<>();

        final ArrayAdapter userAdapter = new ArrayAdapter<String>(view_requests.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        myListview.setAdapter(userAdapter);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Requests");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    i++;
                    String title = snapshot.child("title").getValue().toString();
                    String rq = snapshot.child("request").getValue().toString();


                    list.add("______________________Feedback#"+i);
                    list.add("Title: "+title);
                    list.add("Request: "+rq);


                }
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}