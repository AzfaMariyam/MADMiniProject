package com.example.madminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ItemUpdateDelete extends AppCompatActivity {

    ImageButton back;


    DatabaseReference refDB;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_item_update_delete);
        setContentView(R.layout.activity_item_update_delete);
        refDB = FirebaseDatabase.getInstance().getReference().child("item");

        back = findViewById(R.id.imageButton6);
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ItemUpdateDelete.this, itemAdmin.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<ItemModel> options =
                new FirebaseRecyclerOptions.Builder<ItemModel>()
                        .setQuery(refDB, ItemModel.class)
                        .build();

        FirebaseRecyclerAdapter<ItemModel, ItemUpDelAdapter> adapter=
                new FirebaseRecyclerAdapter<ItemModel, ItemUpDelAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ItemUpDelAdapter holder, int position, @NonNull final ItemModel model) {

                        holder.txtPruductName.setText(model.getName());
                        holder.txtProductCode.setText(model.getCode());

//                        holder.itemView.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(itemDisplay.this, ItemDetails.class);
//                                intent.putExtra("code", model.getCode());
//                                startActivity(intent);
//                            }
//                        });
                    }

                    @NonNull
                    @Override
                    public ItemUpDelAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent,false);
                        ItemUpDelAdapter holder = new ItemUpDelAdapter(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }



}
