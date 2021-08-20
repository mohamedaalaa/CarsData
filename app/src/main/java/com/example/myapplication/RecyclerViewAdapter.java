package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {


    List<PhotoModel.Data> photoModelList;

    public RecyclerViewAdapter(List<PhotoModel.Data> photoModelList) {
        this.photoModelList = photoModelList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_rview,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        PhotoModel.Data data=photoModelList.get(position);
        holder.brand.setText(data.brand);
        holder.year.setText(data.constractionYear);
        Picasso.get().load(data.imageUrl).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return photoModelList.size();
    }

    public class RecyclerViewHolder extends  RecyclerView.ViewHolder{

        TextView brand;
        TextView year;
        TextView isused;
        ImageView image;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            brand=itemView.findViewById(R.id.textBrand);
            year=itemView.findViewById(R.id.constractionYear);
            isused=itemView.findViewById(R.id.isUsed);
            image=itemView.findViewById(R.id.imageCar);
        }
    }



}
