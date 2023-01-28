package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Primec extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primec);
        TextView m=(TextView)findViewById(R.id.messageprimec);
        b=(Button)findViewById(R.id.backprimec);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int n, i, flag = 0;\n" +
                "\n" +
                "    printf(\"Enter a positive integer: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "\n" +
                "    for(i = 2; i <= n/2; ++i)\n" +
                "    {\n" +
                "        // condition for nonprime number\n" +
                "        if(n%i == 0)\n" +
                "        {\n" +
                "            flag = 1;\n" +
                "            break;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    if (n == 1) \n" +
                "    {\n" +
                "      printf(\"1 is neither a prime nor a composite number.\");\n" +
                "    }\n" +
                "    else \n" +
                "    {\n" +
                "        if (flag == 0)\n" +
                "          printf(\"%d is a prime number.\", n);\n" +
                "        else\n" +
                "          printf(\"%d is not a prime number.\", n);\n" +
                "    }\n" +
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
                Intent i = new Intent(Primec.this, Prime.class);
                startActivity(i);
                finish();
            }
        });

}
    }
