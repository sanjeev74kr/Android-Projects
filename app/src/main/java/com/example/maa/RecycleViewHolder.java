package com.example.maa;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewHolder extends RecyclerView.ViewHolder {
    private ImageView profile;
    private TextView cook_name;
    private TextView rating;
    private ImageView banner;


    public RecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        profile =itemView.findViewById(R.id.profile);
        cook_name =itemView.findViewById(R.id.cook_name);
        rating =itemView.findViewById(R.id.rating);
        banner =itemView.findViewById(R.id.banner);

    }

    public ImageView getProfile() {
        return profile;
    }

    public TextView getCook_name() {
        return cook_name;
    }

    public TextView getRating() {
        return rating;
    }

    public ImageView getBanner() {
        return banner;
    }
}
