package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.QuoteSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Multiplication extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        TextView m=(TextView)findViewById(R.id.messagemul);
        b=(Button)findViewById(R.id.backmul);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <stdio.h>\n" +
                " \n" +
                "int main()\n" +
                "{\n" +
                "  int m, n, p, q, c, d, k, sum = 0;\n" +
                "  int first[10][10], second[10][10], multiply[10][10];\n" +
                " \n" +
                "  printf(\"Enter number of rows and columns of first matrix\\n\");\n" +
                "  scanf(\"%d%d\", &m, &n);\n" +
                "  printf(\"Enter elements of first matrix\\n\");\n" +
                " \n" +
                "  for (c = 0; c < m; c++)\n" +
                "    for (d = 0; d < n; d++)\n" +
                "      scanf(\"%d\", &first[c][d]);\n" +
                " \n" +
                "  printf(\"Enter number of rows and columns of second matrix\\n\");\n" +
                "  scanf(\"%d%d\", &p, &q);\n" +
                " \n" +
                "  if (n != p)\n" +
                "    printf(\"The matrices can't be multiplied with each other.\\n\");\n" +
                "  else\n" +
                "  {\n" +
                "    printf(\"Enter elements of second matrix\\n\");\n" +
                " \n" +
                "    for (c = 0; c < p; c++)\n" +
                "      for (d = 0; d < q; d++)\n" +
                "        scanf(\"%d\", &second[c][d]);\n" +
                " \n" +
                "    for (c = 0; c < m; c++) {\n" +
                "      for (d = 0; d < q; d++) {\n" +
                "        for (k = 0; k < p; k++) {\n" +
                "          sum = sum + first[c][k]*second[k][d];\n" +
                "        }\n" +
                " \n" +
                "        multiply[c][d] = sum;\n" +
                "        sum = 0;\n" +
                "      }\n" +
                "    }\n" +
                " \n" +
                "    printf(\"Product of the matrices:\\n\");\n" +
                " \n" +
                "    for (c = 0; c < m; c++) {\n" +
                "      for (d = 0; d < q; d++)\n" +
                "        printf(\"%d\\t\", multiply[c][d]);\n" +
                " \n" +
                "      printf(\"\\n\");\n" +
                "    }\n" +
                "  }\n" +
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
                Intent i=new Intent(Multiplication.this,Questions.class);
                startActivity(i);
                finish();
            }
        });
    }
}
