package com.example.maa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
   List<Cook> cookList;

   public RecycleViewAdapter(List<Cook> cookList)
   {
       this.cookList=cookList;
   }
    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_holder_catalog,parent,false);
        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(view);

        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
       Cook cook=cookList.get(position);
        holder.getCook_name().setText(cook.getCookName());
        holder.getRating().setText(String.valueOf(cook.getRating()));

        Glide.with(holder.getProfile().getContext()).load(cook.getProfilePic())
                .centerCrop()
                .transform(new CircleCrop())
                .into(holder.getProfile());

        Glide.with(holder.getBanner().getContext()).load(cook.getBanner())
                .into(holder.getBanner());

        //Initialize and set on click on recyclerview item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MenuActivity.class);
                intent.putExtra("name", (cookList.get(position)).getCookName());
                intent.putExtra("id", (cookList.get(position)).getId());
                intent.putExtra("rating", (cookList.get(position)).getRating());
                intent.putExtra("profile", (cookList.get(position)).getProfilePic());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return cookList.size();
    }
}
