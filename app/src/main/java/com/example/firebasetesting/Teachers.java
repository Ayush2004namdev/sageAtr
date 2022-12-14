package com.example.firebasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebasetesting.modles.addedStudents;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Teachers extends AppCompatActivity {

    FirebaseDatabase database;
    EditText Sname , Senrollment , Scourse;
    String sname , senrollment , scourse;
    addedStudents add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        database = FirebaseDatabase.getInstance();

    }

    public void addStudent(View view) {
            Sname = findViewById(R.id.newStudentsName);
            Scourse = findViewById(R.id.newStudentCourse);
            Senrollment = findViewById(R.id.newStudentEnrollment);
            scourse = Scourse.getText().toString();
            sname = Sname.getText().toString();
            senrollment = Senrollment.getText().toString();
            add = new addedStudents(sname,senrollment,scourse);
            database.getReference().child("Users").child(senrollment).setValue(add);
            Toast.makeText(this, "Added Sucessfully", Toast.LENGTH_SHORT).show();
    }

    public void Adaptergo(View view) {
        Intent intent = new Intent(this,AttandanceActivity.class);
        startActivity(intent);
    }
}