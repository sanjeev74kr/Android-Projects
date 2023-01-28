package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forwardc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forwardc);
        TextView m=(TextView)findViewById(R.id.messageforwardc);
        b=(Button)findViewById(R.id.backforwardc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="\n" +
                "#include <stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int i, j, n;\n" +
                "\n" +
                "    /* Input number of rows from user */\n" +
                "    printf(\"Enter value of n: \");\n" +
                "    scanf(\"%d\", &n);\n" +
                "\n" +
                "    for(i=1; i<=n; i++)\n" +
                "    {\n" +
                "        /* Print i number of stars */\n" +
                "        for(j=1; j<=i; j++)\n" +
                "        {\n" +
                "            printf(\"*\");\n" +
                "        }\n" +
                "\n" +
                "        /* Move to next line */\n" +
                "        printf(\"\\n\");\n" +
                "    }\n" +
                "\n" +
                "    return 0;\n" +
                "}"+
                "" +
                "" +
                "Output:-"+
                "\n" +
                "* \n" +
                "* * \n" +
                "* * * \n" +
                "* * * * \n" +
                "* * * * * ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Forwardc.this,Forward.class);
                startActivity(i);
                finish();
            }
        });

    }
}
