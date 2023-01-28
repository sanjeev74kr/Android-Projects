package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reversewhile extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reversewhile);

        TextView m=(TextView)findViewById(R.id.messagereverse);
        b=(Button)findViewById(R.id.backreverse);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int n, reversedNumber = 0, remainder;\n" +
                "\n" +
                "    printf(\"Enter an integer: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "\n" +
                "    while(n != 0)\n" +
                "    {\n" +
                "        remainder = n%10;\n" +
                "        reversedNumber = reversedNumber*10 + remainder;\n" +
                "        n /= 10;\n" +
                "    }\n" +
                "\n" +
                "    printf(\"Reversed Number = %d\", reversedNumber);\n" +
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
                Intent i=new Intent(Reversewhile.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
