package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PallindromeC extends AppCompatActivity {
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallindrome_c);
        TextView m=(TextView)findViewById(R.id.messagewindow);
        b=(Button)findViewById(R.id.backpalc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int n, reversedInteger = 0, remainder, originalInteger;\n" +
                "\n" +
                "    printf(\"Enter an integer: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "\n" +
                "    originalInteger = n;\n" +
                "\n" +
                "    // reversed integer is stored in variable \n" +
                "    while( n!=0 )\n" +
                "    {\n" +
                "        remainder = n%10;\n" +
                "        reversedInteger = reversedInteger*10 + remainder;\n" +
                "        n /= 10;\n" +
                "    }\n" +
                "\n" +
                "    // palindrome if orignalInteger and reversedInteger are equal\n" +
                "    if (originalInteger == reversedInteger)\n" +
                "        printf(\"%d is a palindrome.\", originalInteger);\n" +
                "    else\n" +
                "        printf(\"%d is not a palindrome.\", originalInteger);\n" +
                "    \n" +
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
                Intent i=new Intent(PallindromeC.this,Pallindrome.class);
                startActivity(i);
                finish();
            }
        });


    }
}
