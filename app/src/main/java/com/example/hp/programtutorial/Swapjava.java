package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Swapjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swapjava);
        TextView m=(TextView)findViewById(R.id.messageswapjava);
        b=(Button)findViewById(R.id.backswapjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="import java.util.Scanner;\n" +
                " \n" +
                "class SwapNumbers\n" +
                "{\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "      int x, y, temp;\n" +
                "      System.out.println(\"Enter x and y\");\n" +
                "      Scanner in = new Scanner(System.in);\n" +
                "     \n" +
                "      x = in.nextInt();\n" +
                "      y = in.nextInt();\n" +
                "     \n" +
                "      System.out.println(\"Before Swapping\\nx = \"+x+\"\\ny = \"+y);\n" +
                "     \n" +
                "      temp = x;\n" +
                "      x = y;\n" +
                "      y = temp;\n" +
                "     \n" +
                "      System.out.println(\"After Swapping\\nx = \"+x+\"\\ny = \"+y);\n" +
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
                Intent i=new Intent(Swapjava.this,Swap.class);
                startActivity(i);
                finish();
            }
        });
    }
}
