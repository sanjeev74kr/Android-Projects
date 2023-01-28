package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrintIntegerjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_integerjava);
        TextView m=(TextView)findViewById(R.id.messageintjava);
        b=(Button)findViewById(R.id.backintjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="public class JavaProgram\n" +
                "{\n" +
                "    public static void main(String args[])\n" +
                "    {\n" +
                "\t\n" +
                "        int num = 10;\n" +
                "        System.out.println(\"The value of num is \" + num);\n" +
                "\t\t\n" +
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
                Intent i=new Intent(PrintIntegerjava.this,PrintInteger.class);
                startActivity(i);
                finish();
            }
        });
    }
}
