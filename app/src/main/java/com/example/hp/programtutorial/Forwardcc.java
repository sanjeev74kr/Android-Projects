package com.example.hp.programtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forwardcc extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forwardcc);
        TextView m=(TextView)findViewById(R.id.messageforwardcc);
        b=(Button)findViewById(R.id.backforwardcc);

        StringBuilder stringBuilder=new StringBuilder();
        String somemessage="\n" +

                "#include <iostream> \n" +
                "using namespace std; \n" +
                "  \n" +

                "void pypart(int n) \n" +
                "{ \n" +
                "    for (int i=0; i<n; i++) \n" +
                "    { \n" +
                "        for(int j=0; j<=i; j++ ) \n" +
                "        { \n" +
                "            // printing stars \n" +
                "            cout << \"* \"; \n" +
                "        } \n" +
                "  \n" +
                "       cout << endl; \n" +
                "    } \n" +
                "} \n" +
                "  \n" +
                "int main() \n" +
                "{ \n" +
                "    int n = 5; \n" +
                "    pypart(n); \n" +
                "    return 0; \n" +
                "} " +
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
                Intent i=new Intent(Forwardcc.this,Forward.class);
                startActivity(i);
                finish();
            }
        });
    }
}
