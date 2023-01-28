package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Primecc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primecc);
        TextView m=(TextView)findViewById(R.id.messageprimecc);
        b=(Button)findViewById(R.id.backprimecc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "  int n, i;\n" +
                "  bool isPrime = true;\n" +
                "\n" +
                "  cout << \"Enter a positive integer: \";\n" +
                "  cin >> n;\n" +
                "\n" +
                "  for(i = 2; i <= n / 2; ++i)\n" +
                "  {\n" +
                "      if(n % i == 0)\n" +
                "      {\n" +
                "          isPrime = false;\n" +
                "          break;\n" +
                "      }\n" +
                "  }\n" +
                "  if (isPrime)\n" +
                "      cout << \"This is a prime number\";\n" +
                "  else\n" +
                "      cout << \"This is not a prime number\";\n" +
                "\n" +
                "  return 0;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Primecc.this, Prime.class);
                startActivity(i);
                finish();
            }
        });
    }
}
