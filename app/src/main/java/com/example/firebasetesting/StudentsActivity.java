package com.example.firebasetesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasetesting.modles.modals;
import com.example.firebasetesting.modles.studentset;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;

public class StudentsActivity extends AppCompatActivity {
    TextView stuName;
    TextView totalPresenttxt;
    TextView presentStudenttxt;
    DatabaseReference ref;
    modals m = new modals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();
        presentStudenttxt = findViewById(R.id.studentPresent);
        stuName = findViewById(R.id.studentName);
        totalPresenttxt = findViewById(R.id.totalPresent);
        ref = FirebaseDatabase.getInstance().getReference("User");
        ref.child(LoginActivity.id).get().addOnCompleteListener(StudentsActivity.this, new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){

                    DataSnapshot dataSnapshot = task.getResult();
                    String stname = dataSnapshot.child("password").getValue().toString();
                   settt(stname);

                }else {
                    Toast.makeText(StudentsActivity.this, "Failed!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void settt(String stname) {
    stuName.setText(stname);
    }

}