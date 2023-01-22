package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.ArrayList;

public class newVisitors extends AppCompatActivity {
    int i = 0;
    ListView myListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_visitors);
        getSupportActionBar().hide();
        myListview = (ListView) findViewById(R.id.userlist);

        final ArrayList<String> list = new ArrayList<>();

        final ArrayAdapter userAdapter = new ArrayAdapter<String>(newVisitors.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        myListview.setAdapter(userAdapter);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("visitors");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    i++;
                    String name = snapshot.child("_NAME").getValue().toString();
                    String phone = snapshot.child("_PhoneNumber").getValue().toString();
                    String city = snapshot.child("_CITY").getValue().toString();
                    String cnic = snapshot.child("_CNIC").getValue().toString();
                    String refby = snapshot.child("_REFby").getValue().toString();

                    list.add("______________________Vistor#"+i);
                    list.add("Name: "+name);
                    list.add("#Phone:    "+phone);
                    list.add("City: "+city);
                    list.add("#CNIC:    "+cnic);
                    list.add("REFby:    "+refby);

                }
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
