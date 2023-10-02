package com.example.islandbuilder;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataVH> {

    MapData data;
    int id=-99;
    Context c;
    public MyDataAdapter(MapData data,Context c){
        this.data = data;
        this.c = c;
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
        holder.overTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(singleData.getStructure()==null){
                if(id!=-99){holder.overTop.setImageResource(id); data.get(row,col).setStructure(new Structure(id,""));
                ;Toast.makeText(view.getContext(), "Structure Added!",
                            Toast.LENGTH_SHORT).show();}}
                else{holder.overTop.setImageResource(android.R.color.transparent);data.get(row,col).setStructure(null);
                    Toast.makeText(view.getContext(), "Structure Removed!",
                            Toast.LENGTH_SHORT).show();}
            }
        });


        View imageView;
        imageView = new ImageView(c);

        imageView.setOnDragListener( (v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                        ((ImageView)v).setColorFilter(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(c, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    if (e.getResult()) {
                        Toast.makeText(v.getContext(), "The drop was handled.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(v.getContext(), "The drop didn't work.", Toast.LENGTH_LONG).show();
                    }

                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }

            return false;

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