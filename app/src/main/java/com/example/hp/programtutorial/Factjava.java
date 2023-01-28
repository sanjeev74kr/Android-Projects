package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Factjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factjava);
        TextView m=(TextView)findViewById(R.id.messagefactjava);
        b=(Button)findViewById(R.id.backfactjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="class FactorialExample{  \n" +
                " public static void main(String args[]){  \n" +
                "  int i,fact=1;  \n" +
                "  int number=5;//It is the number to calculate factorial    \n" +
                "  for(i=1;i<=number;i++){    \n" +
                "      fact=fact*i;    \n" +
                "  }    \n" +
                "  System.out.println(\"Factorial of \"+number+\" is: \"+fact);    \n" +
                " }  \n" +
                "}  ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Factjava.this,Factorial.class);
                startActivity(i);
                finish();
            }
        });
    }
}
