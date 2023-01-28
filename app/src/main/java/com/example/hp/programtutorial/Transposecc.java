package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Transposecc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transposecc);
        TextView m=(TextView)findViewById(R.id.messagetrcc);
        b=(Button)findViewById(R.id.backtrcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int a[10][10], trans[10][10], r, c, i, j;\n" +
                "\n" +
                "    cout << \"Enter rows and columns of matrix: \";\n" +
                "    cin >> r >> c;\n" +
                "\n" +
                "    // Storing element of matrix entered by user in array a[][].\n" +
                "    cout << endl << \"Enter elements of matrix: \" << endl;\n" +
                "    for(i = 0; i < r; ++i)\n" +
                "    for(j = 0; j < c; ++j)\n" +
                "    {\n" +
                "        cout << \"Enter elements a\" << i + 1 << j + 1 << \": \";\n" +
                "        cin >> a[i][j];\n" +
                "    }\n" +
                "\n" +
                "    // Displaying the matrix a[][]\n" +
                "    cout << endl << \"Entered Matrix: \" << endl;\n" +
                "    for(i = 0; i < r; ++i)\n" +
                "        for(j = 0; j < c; ++j)\n" +
                "        {\n" +
                "            cout << \" \" << a[i][j];\n" +
                "            if(j == c - 1)\n" +
                "                cout << endl << endl;\n" +
                "        }\n" +
                "\n" +
                "    // Finding transpose of matrix a[][] and storing it in array trans[][].\n" +
                "    for(i = 0; i < r; ++i)\n" +
                "        for(j = 0; j < c; ++j)\n" +
                "        {\n" +
                "            trans[j][i]=a[i][j];\n" +
                "        }\n" +
                "\n" +
                "    // Displaying the transpose,i.e, Displaying array trans[][].\n" +
                "    cout << endl << \"Transpose of Matrix: \" << endl;\n" +
                "    for(i = 0; i < c; ++i)\n" +
                "        for(j = 0; j < r; ++j)\n" +
                "        {\n" +
                "            cout << \" \" << trans[i][j];\n" +
                "            if(j == r - 1)\n" +
                "                cout << endl << endl;\n" +
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
                Intent i=new Intent(Transposecc.this,Transpose.class);
                startActivity(i);
                finish();
            }
        });
    }
}
