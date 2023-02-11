package com.example.furnatureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<DataModel>modelArrayList;
    Context context;

    public CustomAdapter(ArrayList<DataModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DataModel model=modelArrayList.get(position);
        holder.textViewName.setText(model.getName());
        holder.textViewVersion.setText(model.getVersion());
        Glide.with(context).load(model.getImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imageViewIcon);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName,textViewVersion;
        ImageView imageViewIcon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.textViewName);
            this.textViewVersion=itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon=itemView.findViewById(R.id.imageViewIcon);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
