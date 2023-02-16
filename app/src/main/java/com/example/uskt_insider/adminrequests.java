package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Requests extends AppCompatActivity {
    int i = 0;
    ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
    /*    getSupportActionBar().hide();

        myListview = (ListView) findViewById(R.id.userlist);
        final ArrayList<String> list = new ArrayList<>();

        final ArrayAdapter userAdapter = new ArrayAdapter<String>(Requests.this, R.layout.list_item, R.id.text_view, list);
        myListview.setAdapter(userAdapter);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Requests");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();


                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    i++;
                    String name = snapshot.child("title").getValue().toString();
                    String fd = snapshot.child("request").getValue().toString();

                    list.add("______________________Request#"+i);
                    list.add("Title: "+name);
                    list.add("Request: "+fd);


                }
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = myListview.getItemAtPosition(i).toString();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Requests.this)
                        .setTitle("Request")
                        .setMessage(txt)
                        .setIcon(R.drawable.insider_logo)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                alertDialog.show();
            }
        });*/
    }
}