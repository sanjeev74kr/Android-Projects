package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Questions extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b8,b9,b10,b11,b12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        b1=(Button)findViewById(R.id.question1);
        b2=(Button)findViewById(R.id.question2);
        b3=(Button)findViewById(R.id.question3);
        b4=(Button)findViewById(R.id.question4);
        b5=(Button)findViewById(R.id.question5);
        b6=(Button)findViewById(R.id.question6);
        b8=(Button)findViewById(R.id.question8);
        b9=(Button)findViewById(R.id.question9);
        b10=(Button)findViewById(R.id.question10);
        b11=(Button)findViewById(R.id.question11);
        b12=(Button)findViewById(R.id.question12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Multiplication.class);
                startActivity(intent);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Fact.class);
                startActivity(intent);
                finish();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Union.class);
                startActivity(intent);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,SortPointers.class);
                startActivity(intent);
                finish();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,File.class);
                startActivity(intent);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Reversewhile.class);
                startActivity(intent);
                finish();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Strings.class);
                startActivity(intent);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Matrix.class);
                startActivity(intent);
                finish();
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Recursion.class);
                startActivity(intent);
                finish();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Removespace.class);
                startActivity(intent);
                finish();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Questions.this,Countwords.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
