package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fbjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbjava);
        TextView m=(TextView)findViewById(R.id.messagefbjava);
        b=(Button)findViewById(R.id.backfbjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="public class Fibonacci {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        int n = 10, t1 = 0, t2 = 1;\n" +
                "        System.out.print(\"First \" + n + \" terms: \");\n" +
                "\n" +
                "        for (int i = 1; i <= n; ++i)\n" +
                "        {\n" +
                "            System.out.print(t1 + \" + \");\n" +
                "\n" +
                "            int sum = t1 + t2;\n" +
                "            t1 = t2;\n" +
                "            t2 = sum;\n" +
                "        }\n" +
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
                Intent i=new Intent(Fbjava.this,Fibonoci.class);
                startActivity(i);
                finish();
            }
        });
    }
}
