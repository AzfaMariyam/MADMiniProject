package com.example.madminiproject;

import android.view.View;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemUpDelAdapter extends RecyclerView.ViewHolder implements  View.OnClickListener {

    public TextView txtPruductName, txtProductCode;

    public ItemClickListner listner;

    public ItemUpDelAdapter(@NonNull View itemView) {
        super(itemView);

        txtPruductName = (TextView)itemView.findViewById(R.id.itemName);
        txtProductCode = (TextView)itemView.findViewById(R.id.icode);
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
