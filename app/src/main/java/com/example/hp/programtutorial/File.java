package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class File extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        TextView m=(TextView)findViewById(R.id.messagefile);
        b=(Button)findViewById(R.id.backfile);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<stdio.h>\n" +
                "#include<conio.h>\n" +
                "void main() {\n" +
                "\tchar ch;\n" +
                "\tint count=0;\n" +
                "\tFILE *fptr;\n" +
                "\tclrscr();\n" +
                "\tfptr=fopen(\"text.txt\",\"w\");\n" +
                "\tif(fptr==NULL) {\n" +
                "\t\tprintf(\"File can't be created\\a\");\n" +
                "\t\tgetch();\n" +
                "\t\texit(0);\n" +
                "\t}\n" +
                "\tprintf(\"Enter some text and press enter key:\\n\");\n" +
                "\twhile((ch=getche())!='\\r') {\n" +
                "\t\tfputc(ch,fptr);\n" +
                "\t}\n" +
                "\tfclose(fptr);\n" +
                "\tfptr=fopen(\"text.txt\",\"r\");\n" +
                "\tprintf(\"\\nContents of the File is:\");\n" +
                "\twhile((ch=fgetc(fptr))!=EOF) {\n" +
                "\t\tcount++;\n" +
                "\t\tprintf(\"%c\",ch);\n" +
                "\t}\n" +
                "\tfclose(fptr);\n" +
                "\tprintf(\"\\nThe number of characters present in file is: %d\",count);\n" +
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
                Intent i=new Intent(File.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
