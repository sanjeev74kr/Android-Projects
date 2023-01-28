package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrintIntegerCC extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_integer_cc);
        TextView m=(TextView)findViewById(R.id.messageintcc);
        b=(Button)findViewById(R.id.backintcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<iostream.h>\n" +
                "#include<conio.h>\n" +
                "void main()\n" +
                "{\n" +
                "\tclrscr();\n" +
                "\tint num=10;\n" +
                "\tcout<<\"The value of num is \"<<num;\n" +
                "\tgetch();\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PrintIntegerCC.this,PrintInteger.class);
                startActivity(i);
                finish();
            }
        });
    }
}
