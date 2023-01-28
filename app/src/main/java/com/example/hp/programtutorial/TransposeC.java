package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransposeC extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transpose_c);
        TextView m=(TextView)findViewById(R.id.messagetrc);
        b=(Button)findViewById(R.id.backtrc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int a[10][10], transpose[10][10], r, c, i, j;\n" +
                "    printf(\"Enter rows and columns of matrix: \");\n" +
                "    scanf(\"%d %d\", &r, &c);\n" +
                "\n" +
                "    // Storing elements of the matrix\n" +
                "    printf(\"\\nEnter elements of matrix:\\n\");\n" +
                "    for(i=0; i<r; ++i)\n" +
                "        for(j=0; j<c; ++j)\n" +
                "        {\n" +
                "            printf(\"Enter element a%d%d: \",i+1, j+1);\n" +
                "            scanf(\"%d\", &a[i][j]);\n" +
                "        }\n" +
                "\n" +
                "    // Displaying the matrix a[][] */\n" +
                "    printf(\"\\nEntered Matrix: \\n\");\n" +
                "    for(i=0; i<r; ++i)\n" +
                "        for(j=0; j<c; ++j)\n" +
                "        {\n" +
                "            printf(\"%d  \", a[i][j]);\n" +
                "            if (j == c-1)\n" +
                "                printf(\"\\n\\n\");\n" +
                "        }\n" +
                "\n" +
                "    // Finding the transpose of matrix a\n" +
                "    for(i=0; i<r; ++i)\n" +
                "        for(j=0; j<c; ++j)\n" +
                "        {\n" +
                "            transpose[j][i] = a[i][j];\n" +
                "        }\n" +
                "\n" +
                "    // Displaying the transpose of matrix a\n" +
                "    printf(\"\\nTranspose of Matrix:\\n\");\n" +
                "    for(i=0; i<c; ++i)\n" +
                "        for(j=0; j<r; ++j)\n" +
                "        {\n" +
                "            printf(\"%d  \",transpose[i][j]);\n" +
                "            if(j==r-1)\n" +
                "                printf(\"\\n\\n\");\n" +
                "        }\n" +
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
                Intent i=new Intent(TransposeC.this,Transpose.class);
                startActivity(i);
                finish();
            }
        });

    }
}
