package com.example.maa;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MenuRecycleViewHolder extends RecyclerView.ViewHolder {
    ImageView dishImage;
    TextView dishName;
    TextView halfPrice;
    TextView fullPrice;
    HorizontalNumberPicker numberPicker;
    RadioButton halfRadio,fullRadio;
    TextView perPiece,price;
    LinearLayout unitPriceLayout,countableLayout;
    TextView text_quantity,text_price;
    RadioGroup priceRadioGroup;
    CardView menuCard;

    public MenuRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        dishImage = itemView.findViewById(R.id.dishImage);
        dishName = itemView.findViewById(R.id.dishName);
        halfPrice = itemView.findViewById(R.id.halfPrice);
        fullPrice = itemView.findViewById(R.id.fullPrice);
        numberPicker = itemView.findViewById(R.id.fullNumberPicker);
        halfRadio = itemView.findViewById(R.id.halfRadio);
        fullRadio = itemView.findViewById(R.id.fullRadio);
        priceRadioGroup=itemView.findViewById(R.id.priceRadioGroup);
        perPiece = itemView.findViewById(R.id.perPiece);
        price = itemView.findViewById(R.id.price);
        unitPriceLayout = itemView.findViewById(R.id.unitPriceLayout);
        numberPicker.setMin(0);
        numberPicker.setMax(100);
        text_quantity = itemView.findViewById(R.id.text_quantity);
        text_price = itemView.findViewById(R.id.text_price);
        countableLayout = itemView.findViewById(R.id.countableLayout);
        menuCard=itemView.findViewById(R.id.menuCard);
    }

    public ImageView getDishImage() {
        return dishImage;
    }

    public TextView getDishName() {
        return dishName;
    }

    public TextView getHalfPrice() {
        return halfPrice;
    }

    public TextView getFullPrice() {
        return fullPrice;
    }


    public HorizontalNumberPicker getNumberPicker() {
        return numberPicker;
    }

    public RadioButton getHalfRadio() {
        return halfRadio;
    }

    public RadioButton getFullRadio() {
        return fullRadio;
    }

    public TextView getPerPiece() {
        return perPiece;
    }

    public TextView getText_quantity() {
        return text_quantity;
    }

    public TextView getText_price() {
        return text_price;
    }

    public TextView getPrice() {
        return price;
    }

    public LinearLayout getUnitPriceLayout() {
        return unitPriceLayout;
    }

    public LinearLayout getCountableLayout() {
        return countableLayout;
    }

    public RadioGroup getPriceRadioGroup() {
        return priceRadioGroup;
    }
}
