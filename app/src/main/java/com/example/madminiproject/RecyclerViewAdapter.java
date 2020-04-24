package com.example.madminiproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mIname = new ArrayList<>();
    private ArrayList<String> mIprice = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context,ArrayList<String> mIname, ArrayList<String> mIprice, ArrayList<String> mImages ) {
        this.mIname = mIname;
        this.mIprice = mIprice;
        this.mImages = mImages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false) ;
        ViewHolder holder = new ViewHolder(view)  ;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.")  ;
        Glide.with(context).asBitmap().load(mImages.get(position)).into(holder.image);

        holder.iname.setText(mIname.get(position));
        holder.iprice.setText(mIprice.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Log.d(TAG,"onClick: clicked on:"+ mIname.get(position));

                Toast.makeText(context, mIname.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView iname, iprice;
        GridLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//
//            image = itemView.findViewById(R.id.imageView8);
//            iname = itemView.findViewById(R.id.textView33);
//            iprice = itemView.findViewById(R.id.textView34);
//            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
