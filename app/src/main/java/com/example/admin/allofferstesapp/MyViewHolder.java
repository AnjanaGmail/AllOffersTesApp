package com.example.admin.allofferstesapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

//Holder for the list item
public class MyViewHolder extends RecyclerView.ViewHolder {
    ViewGroup viewGroup;

    MyViewHolder(View view) {
        super(view);
        viewGroup = (ViewGroup) itemView;
    }
}
