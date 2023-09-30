package com.example.islandbuilder;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapterSelector extends RecyclerView.Adapter<MyDataVHSelector> {

    StructureData data;
    Structure clickedStructure;
    itemClickListener clickListener;
    public MyAdapterSelector(StructureData data, itemClickListener clickListener){
        this.data = data;
        this.clickListener = clickListener;
        clickedStructure = new Structure(R.drawable.ic_building1,"wait");
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

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(singleData);
                //clickedStructure = new Structure(singleData.getDrawableId(),"go");
               // AppCompatActivity activity = (AppCompatActivity)view.getContext();
              //  SelectorFragment selectorFragment = new SelectorFragment();
              //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.selector,selectorFragment).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Structure getClickedStructure(){
        return clickedStructure;
    }
    public interface itemClickListener{
        public void onItemClick(Structure structure);
    }

}
