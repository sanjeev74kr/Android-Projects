package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Palindromejava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindromejava);
        TextView m=(TextView)findViewById(R.id.messagecode);
        b=(Button)findViewById(R.id.backpaljava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="import java.util.*;\n" +
                " \n" +
                "class Palindrome\n" +
                "{\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "      String original, reverse = \"\"; // Objects of String class\n" +
                "      Scanner in = new Scanner(System.in);\n" +
                "     \n" +
                "      System.out.println(\"Enter a string to check if it is a palindrome\");\n" +
                "      original = in.nextLine();\n" +
                "     \n" +
                "      int length = original.length();\n" +
                "     \n" +
                "      for (int i = length - 1; i >= 0; i--)\n" +
                "         reverse = reverse + original.charAt(i);\n" +
                "         \n" +
                "      if (original.equals(reverse))\n" +
                "         System.out.println(\"The string is a palindrome.\");\n" +
                "      else\n" +
                "         System.out.println(\"The string isn't a palindrome.\");\n" +
                "         \n" +
                "   }\n" +
                "}  ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Palindromejava.this,Pallindrome.class);
                startActivity(i);
                finish();
            }
        });
    }
}
