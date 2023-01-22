package com.example.uskt_insider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class viewFeedbacks extends AppCompatActivity {
    int i = 0;
    ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedbacks);
        getSupportActionBar().hide();

        myListview = (ListView) findViewById(R.id.userlist);
        final ArrayList<String> list = new ArrayList<>();

        final ArrayAdapter userAdapter = new ArrayAdapter<String>(viewFeedbacks.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        myListview.setAdapter(userAdapter);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("FeedBacks");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    i++;
                    String name = snapshot.child("giverName").getValue().toString();
                    String fd = snapshot.child("theFeedback").getValue().toString();

                    list.add("______________________Feedback#"+i);
                    list.add("Feedback Giver: "+name);
                    list.add("Feedback: "+fd);


                }
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}