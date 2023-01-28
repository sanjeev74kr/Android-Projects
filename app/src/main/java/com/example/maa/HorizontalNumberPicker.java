package com.example.maa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HorizontalNumberPicker extends LinearLayout {
private TextView number;
private int min,max;
int newValue;
final TextView decrementButton,incrementButton;

    public HorizontalNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context,R.layout.horizontalnumberpicker,this);
        number=findViewById(R.id.number);
        decrementButton=findViewById(R.id.decrementButton);
        incrementButton=findViewById(R.id.incrementButton);
        decrementButton.setOnClickListener(new AddHandler(-1));
        incrementButton.setOnClickListener(new AddHandler(1));
    }

private class AddHandler implements OnClickListener {
    final int diff;

    public AddHandler(int diff) {
        this.diff = diff;
    }

    @Override
    public void onClick(View v) {
         newValue = getValue() + diff;
        if (newValue < min) {
            newValue = min;
        } else if (newValue > max) {
            newValue = max;
        }
        number.setText(String.valueOf(newValue));
    }
}
    public int getValue()
    {
        if(number!=null)
        {
            try {
                final String value=number.getText().toString();
                return Integer.parseInt(value);
            }catch (NumberFormatException e)
            {}
        }
        return 0;
    }
    public void setValue(final int value)
    {
        if(number!=null)
            number.setText(String.valueOf(value));
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

