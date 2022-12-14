package com.example.firebasetesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.firebasetesting.modles.modals;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private String mname;
    private String mpass;
    public static String id;
    FirebaseDatabase database;
    RadioGroup Radio;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Radio = findViewById(R.id.radio);
        Radio.clearCheck();
        Radio.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override

                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {
                        RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
                    }
                });
    }


    public void login(View view) {
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        int selecteid = Radio.getCheckedRadioButtonId();
        radioButton = (RadioButton)Radio.findViewById(selecteid);
        EditText name = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPassword);
        mpass = pass.getText().toString();
        mname = name.getText().toString();
        if (mpass.isEmpty() || mname.isEmpty() ){
            Toast.makeText(getApplicationContext() , "Invalid Credential" , Toast.LENGTH_LONG).show();
        }
        else{
            letsgo(mname,mpass);
        }
    }

    private void letsgo(String name, String pass) {
        auth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                modals Modals = new modals(name , pass);
                //Toast.makeText(getApplicationContext() , "Welcome" , Toast.LENGTH_LONG).show();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                id = user.getUid().toString();
                database.getReference().child("User").child(id).setValue(Modals);
                 Intent i = new Intent(LoginActivity.this,Teachers.class);
                 startActivity(i);
            }
            else{
                Toast.makeText(getApplicationContext() , "Wrong Credentials" , Toast.LENGTH_LONG).show();
            }
            }
        });
    }
}