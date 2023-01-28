package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fbcc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbcc);
        TextView m=(TextView)findViewById(R.id.messagefbcc);
        b=(Button)findViewById(R.id.backfbcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int n, t1 = 0, t2 = 1, nextTerm = 0;\n" +
                "\n" +
                "    cout << \"Enter the number of terms: \";\n" +
                "    cin >> n;\n" +
                "\n" +
                "    cout << \"Fibonacci Series: \";\n" +
                "\n" +
                "    for (int i = 1; i <= n; ++i)\n" +
                "    {\n" +
                "        // Prints the first two terms.\n" +
                "        if(i == 1)\n" +
                "        {\n" +
                "            cout << \" \" << t1;\n" +
                "            continue;\n" +
                "        }\n" +
                "        if(i == 2)\n" +
                "        {\n" +
                "            cout << t2 << \" \";\n" +
                "            continue;\n" +
                "        }\n" +
                "        nextTerm = t1 + t2;\n" +
                "        t1 = t2;\n" +
                "        t2 = nextTerm;\n" +
                "        \n" +
                "        cout << nextTerm << \" \";\n" +
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
                Intent i=new Intent(fbcc.this,Fibonoci.class);
                startActivity(i);
                finish();
            }
        });

    }
}
