package com.noyon.sharedpreferencesloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


           //for the first time when status doesnot have any value so asign it  false as default value

        share = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        boolean check= share.getBoolean("status",false);

        //seting  delay

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //if it true then go for Main page
                if(check){
                    Intent myIntent = new Intent(Splash_Screen.this,MainPage.class);
                    startActivity(myIntent);

                }
                // if it false then first go for login page
                else{
                    Intent myIntent = new Intent(Splash_Screen.this,MainActivity.class);
                    startActivity(myIntent);

                }


            //remove the splash screen from stack so that user could show it once
                finish();


            }
        },3000);





    }
}