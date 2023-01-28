package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FRcc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frcc);
        TextView m=(TextView)findViewById(R.id.messagefrcc);
        b=(Button)findViewById(R.id.backfrcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int factorial(int n);\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int n;\n" +
                "\n" +
                "    cout << \"Enter a positive integer: \";\n" +
                "    cin >> n;\n" +
                "\n" +
                "    cout << \"Factorial of \" << n << \" = \" << factorial(n);\n" +
                "\n" +
                "    return 0;\n" +
                "}\n" +
                "\n" +
                "int factorial(int n)\n" +
                "{\n" +
                "    if(n > 1)\n" +
                "        return n * factorial(n - 1);\n" +
                "    else\n" +
                "        return 1;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FRcc.this,FR.class);
                startActivity(i);
                finish();
            }
        });
    }
}
