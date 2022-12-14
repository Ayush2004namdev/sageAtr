package com.example.firebasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Thread td = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(SplashAct.this , LoginActivity.class);
                    startActivity(i);
                }
            }
        };
        td.start();
    }

}