package com.example.maa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BreakfastRecycleAdapter extends RecyclerView.Adapter<MenuRecycleViewHolder>  {
    List<BreakfastMenu> breakfastList;
    long cookId;
    double price;
     AmountCalculation amountCalculation;
    public BreakfastRecycleAdapter(List<BreakfastMenu> breakfastList, long id) {
        this.breakfastList = breakfastList;
        this.cookId = id;
    }

    public BreakfastRecycleAdapter() {
    }

    @NonNull
    @Override
    public MenuRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_menu, parent, false);
        MenuRecycleViewHolder menuRecycleViewHolder = new MenuRecycleViewHolder(view);
        return menuRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecycleViewHolder holder, int position) {
        BreakfastMenu breakfast = breakfastList.get(position);
        amountCalculation=new AmountCalculation();
        if (breakfast.getCookId() == cookId) {
            Glide.with(holder.getDishImage().getContext()).load(breakfast.getDishImage())
                    .centerCrop()
                    .into(holder.getDishImage());
            holder.getDishName().setText(breakfast.getDishName());

            if (breakfast.isCountable()) {
                holder.getPrice().setText(breakfast.getUnitPrice() + "");
                holder.getHalfRadio().setVisibility(View.GONE);
                holder.getFullRadio().setVisibility(View.GONE);
                holder.getHalfPrice().setVisibility(View.GONE);
                holder.getFullPrice().setVisibility(View.GONE);
                holder.getText_quantity().setVisibility(View.GONE);
                holder.getText_price().setVisibility(View.GONE);
                holder.getNumberPicker().setVisibility(View.VISIBLE);

            } else {

                holder.getUnitPriceLayout().setVisibility(View.GONE);
                holder.getHalfPrice().setText(breakfast.getHalfPrice() + "");
                holder.getFullPrice().setText(breakfast.getFullPrice() + "");

                if (holder.getHalfRadio().isChecked() || holder.getFullRadio().isChecked()) {
                    holder.getNumberPicker().setClickable(true);
                    holder.getNumberPicker().setVisibility(View.VISIBLE);
                } else
                    holder.getNumberPicker().setClickable(false);
                holder.getNumberPicker().setVisibility(View.GONE);

            }
        }
        Log.d("price",  "outside while");

            holder.getHalfRadio().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    BreakfastMenu breakfastMenu = breakfastList.get(holder.getAdapterPosition());
                    double halfPrice = Double.parseDouble(breakfastMenu.getHalfPrice() + "");
                    Context context=v.getContext();
                    if (holder.getHalfRadio().isChecked()) {
                        price = halfPrice;
                        Log.d("price", price + "");
                        double billing=amountCalculation.calculateBill(price);
                        Intent intent=new Intent("passAmount");
                        intent.putExtra("amount",billing);
                        //For passing data from the recycler view item to the view of same activity->LocalBroadcastManager
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                        Log.d("amount", billing + "");

                    }
                }
            });
            holder.getFullRadio().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BreakfastMenu breakfastMenu = breakfastList.get(holder.getAdapterPosition());
                    double fullPrice = Double.parseDouble(breakfastMenu.getFullPrice() + "");
                    Context context=v.getContext();
                    if (holder.getFullRadio().isChecked()) {
                        price = fullPrice;

                        Log.d("price", price + "");
                        double billing=amountCalculation.calculateBill(price);
                        Intent intent=new Intent("passAmount");
                        intent.putExtra("amount",billing);
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                        Log.d("amount", billing + "");
                    }

                }
            });
            if(holder.getNumberPicker().newValue>0){
                    BreakfastMenu breakfastMenu = breakfastList.get(holder.getAdapterPosition());
                    double unitPrice = Double.parseDouble(breakfastMenu.getUnitPrice() + "");
                    Context context=holder.getNumberPicker().getContext();
                    long value=holder.getNumberPicker().newValue;
                        price = holder.getNumberPicker().getValue() * unitPrice;

                        Log.d("price", price + "");
                        double billing=amountCalculation.calculateBill(price);
                        Intent intent=new Intent("passAmount");
                        intent.putExtra("amount",billing);
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                        Log.d("amount", billing + "");

                }


        }





    @Override
    public int getItemCount() {
        return breakfastList.size();
    }

}