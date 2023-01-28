package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Removespace extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removespace);
        TextView m=(TextView)findViewById(R.id.messagespace);
        b=(Button)findViewById(R.id.backspace);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "   char text[1000], blank[1000];\n" +
                "   int c = 0, d = 0;\n" +
                " \n" +
                "   printf(\"Enter some text\\n\");\n" +
                "   gets(text);\n" +
                " \n" +
                "   while (text[c] != '\\0') {\n" +
                "      if (text[c] == ' ') {\n" +
                "         int temp = c + 1;\n" +
                "         if (text[temp] != '\\0') {\n" +
                "            while (text[temp] == ' ' && text[temp] != '\\0') {\n" +
                "               if (text[temp] == ' ') {\n" +
                "                  c++;\n" +
                "               }  \n" +
                "               temp++;\n" +
                "            }\n" +
                "         }\n" +
                "      }\n" +
                "      blank[d] = text[c];\n" +
                "      c++;\n" +
                "      d++;\n" +
                "   }\n" +
                " \n" +
                "   blank[d] = '\\0';\n" +
                " \n" +
                "   printf(\"Text after removing blanks\\n%s\\n\", blank);\n" +
                " \n" +
                "   return 0;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Removespace.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
