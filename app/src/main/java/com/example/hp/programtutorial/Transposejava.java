package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Transposejava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transposejava);
        TextView m=(TextView)findViewById(R.id.messagetrjava);
        b=(Button)findViewById(R.id.backtrjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="import java.util.Scanner;\n" +
                " \n" +
                "class TransposeAMatrix\n" +
                "{\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "      int m, n, c, d;\n" +
                " \n" +
                "      Scanner in = new Scanner(System.in);\n" +
                "      System.out.println(\"Enter the number of rows and columns of matrix\");\n" +
                "      m = in.nextInt();\n" +
                "      n = in.nextInt();\n" +
                " \n" +
                "      int matrix[][] = new int[m][n];\n" +
                "     \n" +
                "      System.out.println(\"Enter the elements of matrix\");\n" +
                " \n" +
                "      for (c = 0; c < m; c++)\n" +
                "         for (d = 0; d < n; d++)\n" +
                "            matrix[c][d] = in.nextInt();\n" +
                " \n" +
                "      int transpose[][] = new int[n][m];\n" +
                "     \n" +
                "      for (c = 0; c < m; c++)\n" +
                "         for (d = 0; d < n; d++)              \n" +
                "            transpose[d][c] = matrix[c][d];\n" +
                " \n" +
                "      System.out.println(\"Transpose of the matrix:\");\n" +
                " \n" +
                "      for (c = 0; c < n; c++)\n" +
                "      {\n" +
                "         for (d = 0; d < m; d++)\n" +
                "               System.out.print(transpose[c][d]+\"\\t\");\n" +
                " \n" +
                "         System.out.print(\"\\n\");\n" +
                "      }\n" +
                "   }\n" +
                "}";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Transposejava.this,Transpose.class);
                startActivity(i);
                finish();
            }
        });
    }
}
