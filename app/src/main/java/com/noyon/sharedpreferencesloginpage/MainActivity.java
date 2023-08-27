package com.noyon.sharedpreferencesloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   EditText edName,edPass;
   Button btnLogin;

   SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.edName);
        edPass=findViewById(R.id.edPass);
        btnLogin= findViewById(R.id.btnLogin);

        //add shared preferences for store data

         share =getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor editor= share.edit();

        //set onclick event for login btn

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //after click login btn make the status true
                editor.putBoolean("status",true);
                editor.apply();

                //now switch activity from Mainactivity to Mainpage activity

                Intent myIntent = new Intent(MainActivity.this,MainPage.class);
                startActivity(myIntent);

                //after switching activity remove this activity from stack
                 finish();



            }
        });


    }
}