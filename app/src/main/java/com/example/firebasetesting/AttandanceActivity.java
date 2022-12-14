package com.example.firebasetesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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

public class AttandanceActivity extends AppCompatActivity {
    ArrayList<String> name = new ArrayList<>();
    String str;
    DatabaseReference reference;
    TextView txt;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandance);
        reference = FirebaseDatabase.getInstance().getReference("Users");
        for (int i = 1 ; i<5 ; i++){
            reference.child("" + i).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot dataSnapshot = task.getResult();
                        if (dataSnapshot.exists()) {
                            String str = dataSnapshot.child("name").getValue().toString();
                            name.add(str);
                        }
                    }
                    else {

                    }
                }
            });
        }
        setgo();



    }

    private void setgo() {
        listView = findViewById(R.id.ayush);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(AttandanceActivity.this , android.R.layout.simple_list_item_1 , name);
        listView.setAdapter(arrayAdapter);
    }
}