package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forwardjava extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forwardjava);
        TextView m=(TextView)findViewById(R.id.messageforwardjava);
        b=(Button)findViewById(R.id.backforwardjava);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="public static void printStars(int n) \n" +
                "    { \n" +
                "        int i, j; \n" +
                "  \n" +
                "        // outer loop to handle number of rows \n" +
                "        //  n in this case \n" +
                "        for(i=0; i<n; i++) \n" +
                "        { \n" +
                "  \n" +
                "            //  inner loop to handle number of columns \n" +
                "            //  values changing acc. to outer loop     \n" +
                "            for(j=0; j<=i; j++) \n" +
                "            { \n" +
                "                // printing stars \n" +
                "                System.out.print(\"* \"); \n" +
                "            } \n" +
                "  \n" +
                "            // ending line after each row \n" +
                "            System.out.println(); \n" +
                "        } \n" +
                "   } "+
                "" +
                "" +
                "Output:-" +
                "\n" +
                "* \n" +
                "* * \n" +
                "* * * \n" +
                "* * * * \n" +
                "* * * * * ";
        for (int i=0;i<1;i++)
        {
            stringBuilder.append(somemessage);
        }
        m.setText(stringBuilder.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Forwardjava.this,Forward.class);
                startActivity(i);
                finish();
            }
        });
    }
}
