package com.example.furnatureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdaptery extends RecyclerView.Adapter <RecyclerViewAdaptery.ImageViewHolder> {
    Context context;
    List<MyRow>myRows;

    public RecyclerViewAdaptery(Context context, List<MyRow> myRows) {
        this.context = context;
        this.myRows = myRows;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fashion_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Glide.with(context).load(myRows.get(position).getImage()).into(holder.imageView);
        holder.tittle.setText(myRows.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return myRows.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView imageView;
        TextView tittle;
        CardView cardView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.poster);
            tittle=itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (getLayoutPosition()==0){
                Toast.makeText(context, "You Clicked First Item", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
