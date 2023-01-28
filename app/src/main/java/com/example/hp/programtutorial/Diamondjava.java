package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Diamondjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondjava);
        TextView m=(TextView)findViewById(R.id.messagediajava);
        b=(Button)findViewById(R.id.backdiajava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="import java.util.Scanner;\n" +
                "public class Diamond\n" +
                "{\n" +
                "    public static void main(String args[]) \n" +
                "    {\n" +
                "        int n, i, j, space = 1;\n" +
                "        System.out.print(\"Enter the number of rows: \");\n" +
                "        Scanner s = new Scanner(System.in);\n" +
                "        n = s.nextInt();\n" +
                "        space = n - 1;\n" +
                "        for (j = 1; j <= n; j++) \n" +
                "        {\n" +
                "            for (i = 1; i <= space; i++) \n" +
                "            {\n" +
                "                System.out.print(\" \");\n" +
                "            }\n" +
                "            space--;\n" +
                "            for (i = 1; i <= 2 * j - 1; i++) \n" +
                "            {\n" +
                "                System.out.print(\"*\");                \n" +
                "            }\n" +
                "            System.out.println(\"\");\n" +
                "        }\n" +
                "        space = 1;\n" +
                "        for (j = 1; j <= n - 1; j++) \n" +
                "        {\n" +
                "            for (i = 1; i <= space; i++) \n" +
                "            {\n" +
                "                System.out.print(\" \");\n" +
                "            }\n" +
                "            space++;\n" +
                "            for (i = 1; i <= 2 * (n - j) - 1; i++) \n" +
                "            {\n" +
                "                System.out.print(\"*\");\n" +
                "            }\n" +
                "            System.out.println(\"\");\n" +
                "        }\n" +
                "    }\n" +
                "}"+
                "\n"+
                "Output:-"+
                "\n"+
                "   *\n" +
                " ***\n" +
                "*****\n" +
                " ***\n" +
                "   *";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Diamondjava.this,Diamond.class);
                startActivity(i);
                finish();
            }
        });
    }
}
