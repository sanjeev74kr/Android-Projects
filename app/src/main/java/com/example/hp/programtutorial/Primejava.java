package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Primejava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primejava);
        TextView m=(TextView)findViewById(R.id.messageprimejava);
        b=(Button)findViewById(R.id.backprimejava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="public class Prime {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        int num = 29;\n" +
                "        boolean flag = false;\n" +
                "        for(int i = 2; i <= num/2; ++i)\n" +
                "        {\n" +
                "            // condition for nonprime number\n" +
                "            if(num % i == 0)\n" +
                "            {\n" +
                "                flag = true;\n" +
                "                break;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        if (!flag)\n" +
                "            System.out.println(num + \" is a prime number.\");\n" +
                "        else\n" +
                "            System.out.println(num + \" is not a prime number.\");\n" +
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
                Intent i = new Intent(Primejava.this, Prime.class);
                startActivity(i);
                finish();
            }
        });

    }
}
