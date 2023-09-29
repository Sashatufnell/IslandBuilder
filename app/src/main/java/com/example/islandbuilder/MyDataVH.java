package com.example.islandbuilder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataVH extends RecyclerView.ViewHolder{

    public ImageView topL;
    public ImageView topR;
    public ImageView bottomL;
    public ImageView bottomR;
    public ImageView overTop;
    public MyDataVH(@NonNull View itemView, ViewGroup parent){
        super(itemView);
        int size = parent.getMeasuredHeight()/MapData.HEIGHT+1;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.width = size;
        lp.height = size;
        topL = itemView.findViewById(R.id.blockTL);
        topR = itemView.findViewById(R.id.blockTR);
        bottomL = itemView.findViewById(R.id.blockBL);
        bottomR = itemView.findViewById(R.id.blockBR);
        overTop = itemView.findViewById(R.id.overTop);
    }

}
