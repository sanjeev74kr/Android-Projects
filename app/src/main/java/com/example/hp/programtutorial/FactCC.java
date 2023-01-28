package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FactCC extends AppCompatActivity {
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_cc);
        TextView m=(TextView)findViewById(R.id.messagefactcc);
        b=(Button)findViewById(R.id.backfactcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    unsigned int n;\n" +
                "    unsigned long long factorial = 1;\n" +
                "\n" +
                "    cout << \"Enter a positive integer: \";\n" +
                "    cin >> n;\n" +
                "\n" +
                "    for(int i = 1; i <=n; ++i)\n" +
                "    {\n" +
                "        factorial *= i;\n" +
                "    }\n" +
                "\n" +
                "    cout << \"Factorial of \" << n << \" = \" << factorial;    \n" +
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
                Intent i=new Intent(FactCC.this,Factorial.class);
                startActivity(i);
                finish();
            }
        });
    }
}
