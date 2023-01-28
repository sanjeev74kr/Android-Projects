package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Armscc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armscc);
        TextView m=(TextView)findViewById(R.id.messagearmscc);
        b=(Button)findViewById(R.id.backarmscc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "  int origNum, num, rem, sum = 0;\n" +
                "  cout << \"Enter a positive  integer: \";\n" +
                "  cin >> origNum;\n" +
                "\n" +
                "  num = origNum;\n" +
                "\n" +
                "  while(num != 0)\n" +
                "  {\n" +
                "      rem = num % 10;\n" +
                "      sum += rem * rem * rem;\n" +
                "      num /= 10;\n" +
                "  }\n" +
                "\n" +
                "  if(sum == origNum)\n" +
                "    cout << origNum << \" is an Armstrong number.\";\n" +
                "  else\n" +
                "    cout << origNum << \" is not an Armstrong number.\";\n" +
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
                Intent i=new Intent(Armscc.this,Armstrong.class);
                startActivity(i);
                finish();
            }
        });
    }
}
