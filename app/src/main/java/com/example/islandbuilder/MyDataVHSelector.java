package com.example.islandbuilder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataVHSelector extends RecyclerView.ViewHolder{
    public TextView description;
    public ImageView image;

    public MyDataVHSelector(@NonNull View itemView, ViewGroup parent) {
        super(itemView);
        int hSize = parent.getMeasuredHeight() /3;
        //int wSize = parent.getMeasuredWidth()/2;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.height = hSize;
        //lp.width = wSize;
        description = itemView.findViewById(R.id.descript);
        image = itemView.findViewById(R.id.image);
    }
}