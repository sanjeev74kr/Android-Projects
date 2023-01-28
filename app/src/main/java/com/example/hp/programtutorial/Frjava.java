package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Frjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frjava);
        TextView m=(TextView)findViewById(R.id.messagefrjava);
        b=(Button)findViewById(R.id.backfrjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="class FactorialDemo2{\n" +
                "   public static void main(String args[]){\n" +
                "      int factorial = fact(4);\n" +
                "      System.out.println(\"Factorial of 4 is: \"+factorial);\n" +
                "   }\n" +
                "   static int fact(int n)\n" +
                "   {\n" +
                "       int output;\n" +
                "       if(n==1){\n" +
                "         return 1;\n" +
                "       }\n" +
                "       //Recursion: Function calling itself!!\n" +
                "       output = fact(n-1)* n;\n" +
                "       return output;\n" +
                "   }\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Frjava.this,FR.class);
                startActivity(i);
                finish();
            }
        });
    }
}
