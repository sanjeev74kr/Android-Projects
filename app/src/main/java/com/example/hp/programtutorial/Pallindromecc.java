package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pallindromecc extends AppCompatActivity {
   Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallindromecc);
        TextView m=(TextView)findViewById(R.id.messagecc);
        b=(Button)findViewById(R.id.backpalcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "     int n, num, digit, rev = 0;\n" +
                "\n" +
                "     cout << \"Enter a positive number: \";\n" +
                "     cin >> num;\n" +
                "\n" +
                "     n = num;\n" +
                "\n" +
                "     do\n" +
                "     {\n" +
                "         digit = num % 10;\n" +
                "         rev = (rev * 10) + digit;\n" +
                "         num = num / 10;\n" +
                "     } while (num != 0);\n" +
                "\n" +
                "     cout << \" The reverse of the number is: \" << rev << endl;\n" +
                "\n" +
                "     if (n == rev)\n" +
                "         cout << \" The number is a palindrome.\";\n" +
                "     else\n" +
                "         cout << \" The number is not a palindrome.\";\n" +
                "\n" +
                "    return 0;\n" +
                "} ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pallindromecc.this,Pallindrome.class);
                startActivity(i);
                finish();
            }
        });

    }
    }
