package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SortPointers extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_pointers);
        TextView m=(TextView)findViewById(R.id.messagesort);
        b=(Button)findViewById(R.id.backsort);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "#include <conio.h>\n" +
                "#include <alloc.h>\n" +
                "void main()\n" +
                "{\n" +
                "\tint n,*p,i,j,temp;\n" +
                "\tclrscr();\n" +
                "\tprintf(\"\\nHOW MANY NUMBER: \");\n" +
                "\tscanf(\"%d\",&n);\n" +
                "\tp=(int *) malloc(n*2);\n" +
                "\tif(p==NULL)\n" +
                "\t{\n" +
                "\t\tprintf(\"\\nMEMORY ALLOCATION UNSUCCESSFUL\");\n" +
                "\t\texit();\n" +
                "\t}\n" +
                "\tfor(i=0;i<n;i++)\n" +
                "\t{\n" +
                "\t\tprintf(\"\\nENTER NUMBER %d: \",i+1);\n" +
                "\t\tscanf(\"%d\",p+i);\n" +
                "\t}\n" +
                "\tfor(i=0;i<n;i++)\n" +
                "\t{\n" +
                "\t\tfor(j=0;j<n;j++)\n" +
                "\t\t{\n" +
                "\t\t\tif(*(p+i)<*(p+j))\n" +
                "\t\t\t{\n" +
                "\t\t\t\ttemp=*(p+i);\n" +
                "\t\t\t\t*(p+i)=*(p+j);\n" +
                "\t\t\t\t*(p+j)=temp;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\tprintf(\"\\nTHE SORTED NUMBERS ARE:\\n\");\n" +
                "\tfor(i=0;i<n;i++)\n" +
                "\t\tprintf(\"%d \",*(p+i));\n" +
                "\tgetch();\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SortPointers.this,Questions.class);
                startActivity(i);
                finish();
            }
        });

    }
}
