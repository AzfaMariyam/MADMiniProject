package com.example.madminiproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements  View.OnClickListener {

    public TextView txtPruductName, txtProductPrice;
    public ImageView imageView;
    public ItemClickListner listner;

    public RecyclerViewAdapter(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.product_image);
        txtPruductName = (TextView)itemView.findViewById(R.id.itemName);
        txtProductPrice = (TextView)itemView.findViewById(R.id.itemPrice);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }


    @Override
    public void onClick(View v) {

        listner.onClick(v, getAdapterPosition(), false);
    }
}
