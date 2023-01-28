package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fact extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        TextView m=(TextView)findViewById(R.id.messagefact);
        b=(Button)findViewById(R.id.backfactorial);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "long int multiplyNumbers(int n);\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int n;\n" +
                "    printf(\"Enter a positive integer: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "    printf(\"Factorial of %d = %ld\", n, multiplyNumbers(n));\n" +
                "    return 0;\n" +
                "}\n" +
                "long int multiplyNumbers(int n)\n" +
                "{\n" +
                "    if (n >= 1)\n" +
                "        return n*multiplyNumbers(n-1);\n" +
                "    else\n" +
                "        return 1;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fact.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
