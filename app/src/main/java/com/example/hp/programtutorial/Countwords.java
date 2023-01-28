package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Countwords extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countwords);
        TextView m=(TextView)findViewById(R.id.messagecount);
        b=(Button)findViewById(R.id.backcount);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "#include <string.h>\n" +
                " \n" +
                "void main()\n" +
                "{\n" +
                "    char s[200];\n" +
                "    int count = 0, i;\n" +
                " \n" +
                "    printf(\"enter the string\\n\");\n" +
                "    scanf(\"%[^\\n]s\", s);\n" +
                "    for (i = 0;s[i] != '\\0';i++)\n" +
                "    {\n" +
                "        if (s[i] == ' ')\n" +
                "            count++;    \n" +
                "    }\n" +
                "    printf(\"number of words in given string are: %d\\n\", count + 1);\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Countwords.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
