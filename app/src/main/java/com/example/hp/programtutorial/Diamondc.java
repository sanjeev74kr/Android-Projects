package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Diamondc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondc);
        TextView m=(TextView)findViewById(R.id.messagediac);
        b=(Button)findViewById(R.id.backdiac);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "  int n, c, k, space = 1;\n" +
                " \n" +
                "  printf(\"Enter number of rows\\n\");\n" +
                "  scanf(\"%d\", &n);\n" +
                " \n" +
                "  space = n - 1;\n" +
                " \n" +
                "  for (k = 1; k <= n; k++)\n" +
                "  {\n" +
                "    for (c = 1; c <= space; c++)\n" +
                "      printf(\" \");\n" +
                " \n" +
                "    space--;\n" +
                " \n" +
                "    for (c = 1; c <= 2*k-1; c++)\n" +
                "      printf(\"*\");\n" +
                " \n" +
                "    printf(\"\\n\");\n" +
                "  }\n" +
                " \n" +
                "  space = 1;\n" +
                " \n" +
                "  for (k = 1; k <= n - 1; k++)\n" +
                "  {\n" +
                "    for (c = 1; c <= space; c++)\n" +
                "      printf(\" \");\n" +
                " \n" +
                "    space++;\n" +
                " \n" +
                "    for (c = 1 ; c <= 2*(n-k)-1; c++)\n" +
                "      printf(\"*\");\n" +
                " \n" +
                "    printf(\"\\n\");\n" +
                "  }\n" +
                " \n" +
                "  return 0;\n" +
                "}"+
                "\n"+
                "Output:-"+
                "\n"+
                "   *\n" +
                " ***\n" +
                "*****\n" +
                " ***\n" +
                "   *"
                ;
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Diamondc.this,Diamond.class);
                startActivity(i);
                finish();
            }
        });
    }
}
