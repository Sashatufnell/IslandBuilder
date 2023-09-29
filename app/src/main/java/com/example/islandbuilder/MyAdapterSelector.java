package com.example.islandbuilder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterSelector extends RecyclerView.Adapter<MyDataVHSelector> {

    StructureData data;
    public MyAdapterSelector(StructureData data){
        this.data = data;
    }
    @NonNull
    @Override
    public MyDataVHSelector onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_selection,
                parent,false);
        MyDataVHSelector myDataVHolderAdv = new MyDataVHSelector(view,parent);
        return myDataVHolderAdv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataVHSelector holder, int position) {
        Structure singleData = data.get(position);
        holder.description.setText(singleData.getLabel());
        holder.image.setImageResource(singleData.getDrawableId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
