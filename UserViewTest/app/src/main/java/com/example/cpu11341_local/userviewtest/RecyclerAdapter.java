package com.example.cpu11341_local.userviewtest;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CPU11341-local on 8/1/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<Dataprovider> arrayList = new ArrayList<Dataprovider>();
    public RecyclerAdapter(ArrayList<Dataprovider> arrayList){
        this.arrayList = arrayList;
    }
    private OnItemClickListener onItemClickListener;

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final Dataprovider dataprovider = arrayList.get(position);
        holder.imageViewIcon.setImageResource(dataprovider.getImg_res());
        holder.textViewString.setText(dataprovider.getItemName());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(dataprovider);
            }
        };
        holder.imageViewIcon.setOnClickListener(listener);
        holder.textViewString.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewIcon;
        TextView textViewString;
        public RecyclerViewHolder(View view){
            super(view);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
            textViewString = (TextView) view.findViewById(R.id.textViewString);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
