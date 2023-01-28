package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Comparecc extends AppCompatActivity
{
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparecc);
        TextView m=(TextView)findViewById(R.id.messagecomparecc);
        b=(Button)findViewById(R.id.backcomparecc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<iostream.h>\n" +
                "#include<string.h>\n" +
                "using namespace std;\n" +
                "int main ()\n" +
                "{\n" +
                "    char str1[50], str2[50];\n" +
                "    cout<<\"Enter string 1 : \";\n" +
                "    gets(str1);\n" +
                "    cout<<\"Enter string 2 : \";\n" +
                "    gets(str2);\n" +
                "    if(strcmp(str1, str2)==0)\n" +
                "        cout << \"Strings are equal!\";\n" +
                "    else\n" +
                "        cout << \"Strings are not equal.\";\n" +
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
                Intent i=new Intent(Comparecc.this,Compare.class);
                startActivity(i);
                finish();
            }
        });
    }
}
