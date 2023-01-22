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

public class givefeedback extends AppCompatActivity {
    EditText feedback_giver;
    EditText the_Feedback;
    Button Submit;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givefeedback);
        getSupportActionBar().hide();
        feedback_giver = (EditText) findViewById(R.id.feedbackgivername);
        the_Feedback = (EditText) findViewById(R.id.thefeedback);
        Submit = (Button) findViewById(R.id.submitfeedback);
        myRef = FirebaseDatabase.getInstance().getReference().child("FeedBacks");
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _feedbackGiver = feedback_giver.getText().toString();
                String _theFeedback = the_Feedback.getText().toString();
                if(_feedbackGiver.equals("")||_theFeedback.equals("")){
                    Toast.makeText(givefeedback.this, "Please fill all the entries", Toast.LENGTH_SHORT).show();
                }
                else{
                    FeedBack_Giver_Class newFeedback = new FeedBack_Giver_Class(_feedbackGiver,_theFeedback);
                    myRef.push().setValue(newFeedback);
                    Toast.makeText(givefeedback.this, "Feedback submitted successfully", Toast.LENGTH_SHORT).show();
                    Intent visitorPage = new Intent(givefeedback.this,visitorpage.class);
                    startActivity(visitorPage);
                }
            }
        });




    }
}