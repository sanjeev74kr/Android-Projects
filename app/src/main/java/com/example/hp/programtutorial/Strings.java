package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Strings extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings);
        TextView m=(TextView)findViewById(R.id.messagestrings);
        b=(Button)findViewById(R.id.backstrings);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "   char str[1000], ch;\n" +
                "   int i, frequency = 0;\n" +
                "\n" +
                "   printf(\"Enter a string: \");\n" +
                "   gets(str);\n" +
                "\n" +
                "   printf(\"Enter a character to find the frequency: \");\n" +
                "   scanf(\"%c\",&ch);\n" +
                "\n" +
                "   for(i = 0; str[i] != '\\0'; ++i)\n" +
                "   {\n" +
                "       if(ch == str[i])\n" +
                "           ++frequency;\n" +
                "   }\n" +
                "\n" +
                "   printf(\"Frequency of %c = %d\", ch, frequency);\n" +
                "\n" +
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
                Intent i=new Intent(Strings.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
