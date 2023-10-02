package com.example.islandbuilder;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    Context c;

    public MyAdapterSelector(StructureData data, itemClickListener clickListener, Context c){
        this.data = data;
        this.clickListener = clickListener;
        this.c = c;
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
        ImageView imageView = new ImageView(c);;
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

        holder.image.setTag("Image");

        holder.image.setOnLongClickListener( v -> {

            Toast.makeText(c,"long click", Toast.LENGTH_LONG).show();
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

            ClipData dragData = new ClipData(
                    (CharSequence) v.getTag(),
                    new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                    item);


            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);


            v.startDragAndDrop(dragData,  // The data to be dragged.
                    myShadow,  // The drag shadow builder.
                    null,      // No need to use local data.
                    0          // Flags. Not currently used, set to 0.
            );

            return true;
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
