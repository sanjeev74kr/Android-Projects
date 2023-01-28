package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickSignUp(View view) {
        Intent intent =new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
    }

    public void onClickForgotPassword(View view) {
    }
}