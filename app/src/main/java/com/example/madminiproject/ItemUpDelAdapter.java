package com.example.madminiproject;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemUpDelAdapter extends RecyclerView.ViewHolder implements  View.OnClickListener {

    public TextView txtPruductName, txtProductCode;
    public Button updateI, deleteI;

    public ItemClickListner listner;

    public ItemUpDelAdapter(@NonNull View itemView) {
        super(itemView);

        txtPruductName = (TextView)itemView.findViewById(R.id.itemName);
        txtProductCode = (TextView)itemView.findViewById(R.id.icode);
        updateI = (Button)itemView.findViewById(R.id.button13);
        deleteI = (Button)itemView.findViewById(R.id.button14);
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
