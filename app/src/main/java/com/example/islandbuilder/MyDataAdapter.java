package com.example.islandbuilder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataVH> {

    MapData data;
    public MyDataAdapter(MapData data){
        this.data = data;
    }
    @NonNull
    @Override
    public MyDataVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.grid_cell,
                parent,false);
        MyDataVH myDataVHolder = new MyDataVH(view,parent);
        return myDataVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataVH holder, int position) {
        int row = position% data.HEIGHT;
        int col = position/data.HEIGHT;
        MapElement singleData = data.get(row,col);
        holder.topR.setImageResource(singleData.getNorthWest());
        holder.topL.setImageResource(singleData.getNorthEast());
        holder.bottomL.setImageResource(singleData.getSouthWest());
        holder.bottomR.setImageResource(singleData.getSouthEast());

    }

    @Override
    public int getItemCount() {
        return data.HEIGHT*data.WIDTH;
    }
}