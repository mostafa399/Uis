package com.example.furnatureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MedicalAdapter extends RecyclerView.Adapter<MedicalAdapter.ImageViewHolder> {
    Context mContext;
    List<MedicalRow> mData;

    public MedicalAdapter(Context mContext, List<MedicalRow> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).
                inflate(R.layout.medical_item,
                        parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Glide.
                with(mContext)
                .load(mData.get(position).getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewMedical);

            // Click Listeners
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (getLayoutPosition() == 0){
                Toast.makeText(mContext,
                        "You Clicked me ",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
