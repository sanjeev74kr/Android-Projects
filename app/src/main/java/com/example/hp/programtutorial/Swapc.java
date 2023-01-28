package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Swapc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swapc);
        TextView m=(TextView)findViewById(R.id.messageswapc);
        b=(Button)findViewById(R.id.backswapc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "      double firstNumber, secondNumber, temporaryVariable;\n" +
                "\n" +
                "      printf(\"Enter first number: \");\n" +
                "      scanf(\"%lf\", &firstNumber);\n" +
                "\n" +
                "      printf(\"Enter second number: \");\n" +
                "      scanf(\"%lf\",&secondNumber);\n" +
                "\n" +
                "      temporaryVariable = firstNumber;\n" +
                "\n" +
                "      firstNumber = secondNumber;\n" +
                "\n" +
                "      secondNumber = temporaryVariable;\n" +
                "\n" +
                "      printf(\"\\nAfter swapping, firstNumber = %.2lf\\n\", firstNumber);\n" +
                "      printf(\"After swapping, secondNumber = %.2lf\", secondNumber);\n" +
                "\n" +
                "      return 0;\n" +
                "}\n";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Swapc.this,Swap.class);
                startActivity(i);
                finish();
            }
        });
    }
}
