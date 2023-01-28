package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recursion extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursion);
        TextView m=(TextView)findViewById(R.id.messagerecursion);
        b=(Button)findViewById(R.id.backrecursion);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int fibo(int);\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "    int num;\n" +
                "    int result;\n" +
                " \n" +
                "    printf(\"Enter the nth number in fibonacci series: \");\n" +
                "    scanf(\"%d\", &num);\n" +
                "    if (num < 0)\n" +
                "    {\n" +
                "        printf(\"Fibonacci of negative number is not possible.\\n\");\n" +
                "    }\n" +
                "    else\n" +
                "    {\n" +
                "        result = fibo(num);\n" +
                "        printf(\"The %d number in fibonacci series is %d\\n\", num, result);\n" +
                "    }\n" +
                "    return 0;\n" +
                "}\n" +
                "int fibo(int num)\n" +
                "{\n" +
                "    if (num == 0)\n" +
                "    {\n" +
                "        return 0;\n" +
                "    }\n" +
                "    else if (num == 1)\n" +
                "    {\n" +
                "        return 1;\n" +
                "    }\n" +
                "    else\n" +
                "    {\n" +
                "        return(fibo(num - 1) + fibo(num - 2));\n" +
                "    }\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Recursion.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
