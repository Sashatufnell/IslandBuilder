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
    int id=-99;
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
        holder.topL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=-99){holder.topL.setImageResource(id);}
            }
        });
        holder.topR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=-99){holder.topR.setImageResource(id);}
            }
        });
        holder.bottomL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=-99){holder.bottomL.setImageResource(id);}
            }
        });
        holder.bottomR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=-99){holder.bottomR.setImageResource(id);}
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.HEIGHT*data.WIDTH;
    }

    public void setStructure(int id){
        this.id = id;
    }
}