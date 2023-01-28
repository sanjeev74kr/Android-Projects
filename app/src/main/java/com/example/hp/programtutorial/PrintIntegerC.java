package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrintIntegerC extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_integer_c);
        TextView m=(TextView)findViewById(R.id.messageintc);
        b=(Button)findViewById(R.id.backintc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "  int a;\n" +
                " \n" +
                "  printf(\"Enter an integer\\n\");\n" +
                "  scanf(\"%d\", &a);\n" +
                " \n" +
                "  printf(\"The integer is %d\\n\", a);\n" +
                " \n" +
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
                Intent i=new Intent(PrintIntegerC.this,PrintInteger.class);
                startActivity(i);
                finish();
            }
        });

    }
}
