package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Diamondcc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondcc);
        TextView m=(TextView)findViewById(R.id.messagediacc);
        b=(Button)findViewById(R.id.backdiacc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<iostream.h>\n" +
                "#include<conio.h>\n" +
                "void main()\n" +
                "{\n" +
                "    clrscr();\n" +
                "    int n, c, k, space=1;\n" +
                "    cout<<\"Enter number of rows (for diamond dimension) : \";\n" +
                "    cin>>n;\n" +
                "    space=n-1;\n" +
                "    for (k=1; k<=n; k++)\n" +
                "    {\n" +
                "\tfor(c=1; c<=space; c++)\n" +
                "\t{\n" +
                "\t\tcout<<\" \";\n" +
                "\t}\n" +
                "\tspace--;\n" +
                "\tfor(c=1; c<=(2*k-1); c++)\n" +
                "\t{\n" +
                "\t\tcout<<\"*\";\n" +
                "\t}\n" +
                "\tcout<<\"\\n\";\n" +
                "    }\n" +
                "    space=1;\n" +
                "    for(k=1; k<=(n-1); k++)\n" +
                "    {\n" +
                "\tfor(c=1; c<=space; c++)\n" +
                "\t{\n" +
                "\t\tcout<<\" \";\n" +
                "\t}\n" +
                "\tspace++;\n" +
                "\tfor(c=1 ; c<=(2*(n-k)-1); c++)\n" +
                "\t{\n" +
                "\t\tcout<<\"*\";\n" +
                "\t}\n" +
                "\tcout<<\"\\n\";\n" +
                "    }\n" +
                "    getch();\n" +
                "}"+
                "\n"+
                "Output:-"+
                "\n"+
                "   *\n" +
                " ***\n" +
                "*****\n" +
                " ***\n" +
                "   *";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Diamondcc.this,Diamond.class);
                startActivity(i);
                finish();
            }
        });
    }
}
