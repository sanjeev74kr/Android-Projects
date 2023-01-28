package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Armsjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armsjava);
        TextView m=(TextView)findViewById(R.id.messagearmsjava);
        b=(Button)findViewById(R.id.backarmsjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="class ArmstrongExample{  \n" +
                "  public static void main(String[] args)  {  \n" +
                "    int c=0,a,temp;  \n" +
                "    int n=153;//It is the number to check armstrong  \n" +
                "    temp=n;  \n" +
                "    while(n>0)  \n" +
                "    {  \n" +
                "    a=n%10;  \n" +
                "    n=n/10;  \n" +
                "    c=c+(a*a*a);  \n" +
                "    }  \n" +
                "    if(temp==c)  \n" +
                "    System.out.println(\"armstrong number\");   \n" +
                "    else  \n" +
                "        System.out.println(\"Not armstrong number\");   \n" +
                "   }  \n" +
                "}  ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Armsjava.this,Armstrong.class);
                startActivity(i);
                finish();
            }
        });
    }
}
