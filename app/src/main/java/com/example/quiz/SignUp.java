package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText uniqueId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiity_signup);
        uniqueId=findViewById(R.id.edit_uniqueId);
    }

    public void onClickRegister(View view) {

    }

    public void onClickFaculty(View view) {}
}
