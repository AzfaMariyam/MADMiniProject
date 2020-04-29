package com.example.madminiproject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cpName, cpPrice, cpQty;
    private ItemClickListener itemClickListener;

    public CartViewHolder(@NonNull  View itemView) {
        super(itemView);
        cpName = itemView.findViewById(R.id.cpname);
        cpPrice = itemView.findViewById(R.id.cpprice);
        cpQty = itemView.findViewById(R.id.cpqty);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
