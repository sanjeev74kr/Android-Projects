package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class comparejava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparejava);
        TextView m=(TextView)findViewById(R.id.messagecomparejava);
        b=(Button)findViewById(R.id.backcomparejava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="public class CompareStrings {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        String style = \"Bold\";\n" +
                "        String style2 = \"Bold\";\n" +
                "\n" +
                "        if(style == style2)\n" +
                "            System.out.println(\"Equal\");\n" +
                "        else\n" +
                "            System.out.println(\"Not Equal\");\n" +
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
                Intent i=new Intent(comparejava.this,Compare.class);
                startActivity(i);
                finish();
            }
        });
    }
}
