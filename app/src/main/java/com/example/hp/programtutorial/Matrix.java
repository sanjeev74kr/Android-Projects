package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Matrix extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        TextView m=(TextView)findViewById(R.id.messagematrix);
        b=(Button)findViewById(R.id.backmatrix);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include<stdio.h>\n" +
                "#include<conio.h>\n" +
                " \n" +
                "main()\n" +
                "{\n" +
                "   int c, d, matrix[10][10], maximum;\n" +
                " \n" +
                "   printf(\"Enter the elements of matrix\\n\");\n" +
                " \n" +
                "   for( c = 0 ; c < 4 ; c++ )\n" +
                "   {\n" +
                "      for( d = 0 ; d < 4 ; d++ )\n" +
                "      {\n" +
                "         scanf(\"%d\",&matrix[c][d]);\n" +
                "      }\n" +
                "   }\n" +
                "   \n" +
                "   maximum = matrix[0][0];\n" +
                " \n" +
                "   for( c = 0 ; c < 4 ; c++ )\n" +
                "   {\n" +
                "      for( d = 0 ; d < 4 ; d++ )\n" +
                "      {\n" +
                "         if ( matrix[c][d] > maximum )\n" +
                "            maximum = matrix[c][d];\n" +
                "      }\n" +
                "   }\n" +
                " \n" +
                "   printf(\"Maximum element in matrix is %d\\n\", maximum);\n" +
                " \n" +
                "   getch();\n" +
                "   return 0;\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Matrix.this,Questions.class);
                startActivity(i);
                finish();
            }
        });

    }
}
