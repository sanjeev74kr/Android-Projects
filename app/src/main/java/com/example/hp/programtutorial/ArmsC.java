package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArmsC extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_c);
        TextView m=(TextView)findViewById(R.id.messagearmsc);
        b=(Button)findViewById(R.id.backarmc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int number, originalNumber, remainder, result = 0;\n" +
                "\n" +
                "    printf(\"Enter a three digit integer: \");\n" +
                "    scanf(\"%d\", &number);\n" +
                "\n" +
                "    originalNumber = number;\n" +
                "\n" +
                "    while (originalNumber != 0)\n" +
                "    {\n" +
                "        remainder = originalNumber%10;\n" +
                "        result += remainder*remainder*remainder;\n" +
                "        originalNumber /= 10;\n" +
                "    }\n" +
                "\n" +
                "    if(result == number)\n" +
                "        printf(\"%d is an Armstrong number.\",number);\n" +
                "    else\n" +
                "        printf(\"%d is not an Armstrong number.\",number);\n" +
                "\n" +
                "    return 0;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ArmsC.this,Armstrong.class);
                startActivity(i);
                finish();
            }
        });
    }
}
