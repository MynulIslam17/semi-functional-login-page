package com.noyon.sharedpreferencesloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

   Button btnLogout;
   SharedPreferences share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnLogout=findViewById(R.id.btnLogout);

        share =getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();

        //set onClick event for logout button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //when click on logout set status false
                editor.putBoolean("status",false);
                editor.apply();

                // Then switvhing into log out activity
                Intent myIntent = new Intent(MainPage.this,MainActivity.class);
                startActivity(myIntent);

                //remove this activity from stack
                finish();



            }
        });


    }
}