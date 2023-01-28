package com.example.maa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LunchRecyclerAdapter extends RecyclerView.Adapter<MenuRecycleViewHolder> {
    @NonNull
    @Override
    public MenuRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_holder_menu,parent,false);
        MenuRecycleViewHolder menuRecycleViewHolder=new MenuRecycleViewHolder(view);
        return menuRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecycleViewHolder holder, int position) {
        holder.getUnitPriceLayout();
        holder.getPrice();
        holder.getHalfPrice();
        holder.getFullPrice();
        holder.getDishName();
        holder.getDishImage();
        holder.getNumberPicker();
        holder.getHalfRadio();
        holder.getFullRadio();
        holder.getPerPiece();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
