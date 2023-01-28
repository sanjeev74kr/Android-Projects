package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fbc extends AppCompatActivity {
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbc);
        TextView m=(TextView)findViewById(R.id.messagefbc);
        b=(Button)findViewById(R.id.backfbc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int i, n, t1 = 0, t2 = 1, nextTerm;\n" +
                "\n" +
                "    printf(\"Enter the number of terms: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "\n" +
                "    printf(\"Fibonacci Series: \");\n" +
                "\n" +
                "    for (i = 1; i <= n; ++i)\n" +
                "    {\n" +
                "        printf(\"%d, \", t1);\n" +
                "        nextTerm = t1 + t2;\n" +
                "        t1 = t2;\n" +
                "        t2 = nextTerm;\n" +
                "    }\n" +
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
                Intent i=new Intent(Fbc.this,Fibonoci.class);
                startActivity(i);
                finish();
            }
        });

    }
}
