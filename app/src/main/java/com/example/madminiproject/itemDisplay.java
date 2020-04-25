package com.example.madminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class itemDisplay extends AppCompatActivity {
    private static final String TAG = "itemDisplay";

    DatabaseReference refDB;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        Log.d(TAG, "oncreate: started");

        refDB = FirebaseDatabase.getInstance().getReference().child("item");

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<ItemModel>options =
                new FirebaseRecyclerOptions.Builder<ItemModel>()
                .setQuery(refDB, ItemModel.class)
                .build();

        FirebaseRecyclerAdapter<ItemModel, RecyclerViewAdapter> adapter=
                new FirebaseRecyclerAdapter<ItemModel, RecyclerViewAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position, @NonNull ItemModel model) {

                        holder.txtPruductName.setText(model.getName());
                        holder.txtProductPrice.setText("Rs" + model.getPrice() + ".00");

                        Picasso.get().load(model.getImg()).into(holder.imageView);
                    }

                    @NonNull
                    @Override
                    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent,false);
                        RecyclerViewAdapter holder = new RecyclerViewAdapter(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}
