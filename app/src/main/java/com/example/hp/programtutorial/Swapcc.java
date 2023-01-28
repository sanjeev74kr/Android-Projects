package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Swapcc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swapcc);
        TextView m=(TextView)findViewById(R.id.messageswapcc);
        b=(Button)findViewById(R.id.backswapcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int a = 5, b = 10, temp;\n" +
                "\n" +
                "    cout << \"Before swapping.\" << endl;\n" +
                "    cout << \"a = \" << a << \", b = \" << b << endl;\n" +
                "\n" +
                "    temp = a;\n" +
                "    a = b;\n" +
                "    b = temp;\n" +
                "\n" +
                "    cout << \"\\nAfter swapping.\" << endl;\n" +
                "    cout << \"a = \" << a << \", b = \" << b << endl;\n" +
                "\n" +
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
                Intent i=new Intent(Swapcc.this,Swap.class);
                startActivity(i);
                finish();
            }
        });
    }
}
