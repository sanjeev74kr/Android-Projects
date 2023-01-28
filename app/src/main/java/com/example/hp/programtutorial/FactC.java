package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FactC extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_c);
        TextView m=(TextView)findViewById(R.id.messagefactc);
        b=(Button)findViewById(R.id.backfactc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int n, i;\n" +
                "    unsigned long long factorial = 1;\n" +
                "\n" +
                "    printf(\"Enter an integer: \");\n" +
                "    scanf(\"%d\",&n);\n" +
                "\n" +
                "    // show error if the user enters a negative integer\n" +
                "    if (n < 0)\n" +
                "        printf(\"Error! Factorial of a negative number doesn't exist.\");\n" +
                "\n" +
                "    else\n" +
                "    {\n" +
                "        for(i=1; i<=n; ++i)\n" +
                "        {\n" +
                "            factorial *= i;              // factorial = factorial*i;\n" +
                "        }\n" +
                "        printf(\"Factorial of %d = %llu\", n, factorial);\n" +
                "    }\n" +
                "\n" +
                "    return 0;\n" +
                "}\n";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FactC.this,Factorial.class);
                startActivity(i);
                finish();
            }
        });
    }
}
