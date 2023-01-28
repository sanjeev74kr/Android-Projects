package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Union extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union);
        TextView m=(TextView)findViewById(R.id.messageunion);
        b=(Button)findViewById(R.id.backunion);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage=
                "#include <stdio.h>\n" +
                "#include <string.h>\n" +
                " \n" +
                "union student \n" +
                "{\n" +
                "            char name[20];\n" +
                "            char subject[20];\n" +
                "            float percentage;\n" +
                "};\n" +
                " \n" +
                "int main() \n" +
                "{\n" +
                "    union student record1;\n" +
                "    union student record2;\n" +
                " \n" +
                "    // assigning values to record1 union variable\n" +
                "       strcpy(record1.name, \"Raju\");\n" +
                "       strcpy(record1.subject, \"Maths\");\n" +
                "       record1.percentage = 86.50;\n" +
                " \n" +
                "       printf(\"Union record1 values example\\n\");\n" +
                "       printf(\" Name       : %s \\n\", record1.name);\n" +
                "       printf(\" Subject    : %s \\n\", record1.subject);\n" +
                "       printf(\" Percentage : %f \\n\\n\", record1.percentage);\n" +
                " \n" +
                "    // assigning values to record2 union variable\n" +
                "       printf(\"Union record2 values example\\n\");\n" +
                "       strcpy(record2.name, \"Mani\");\n" +
                "       printf(\" Name       : %s \\n\", record2.name);\n" +
                " \n" +
                "       strcpy(record2.subject, \"Physics\");\n" +
                "       printf(\" Subject    : %s \\n\", record2.subject);\n" +
                " \n" +
                "       record2.percentage = 99.50;\n" +
                "       printf(\" Percentage : %f \\n\", record2.percentage);\n" +
                "       return 0;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Union.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
