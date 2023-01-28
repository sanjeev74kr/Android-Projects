package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Comparec extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparec);
        TextView m=(TextView)findViewById(R.id.messagecomparec);
        b=(Button)findViewById(R.id.backcomparec);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "#include <string.h>\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "   char a[100], b[100];\n" +
                " \n" +
                "   printf(\"Enter a string\\n\");\n" +
                "   gets(a);\n" +
                " \n" +
                "   printf(\"Enter a string\\n\");\n" +
                "   gets(b);\n" +
                " \n" +
                "   if (strcmp(a,b) == 0)\n" +
                "      printf(\"The strings are equal.\\n\");\n" +
                "   else\n" +
                "      printf(\"The strings are not equal.\\n\");\n" +
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
                Intent i=new Intent(Comparec.this,Compare.class);
                startActivity(i);
                finish();
            }
        });
    }
}
