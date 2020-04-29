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
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ItemUpdateDelete extends AppCompatActivity {

    ImageButton back;
    DatabaseReference refDB;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private ItemModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        //load to product details
        FirebaseRecyclerOptions<ItemModel>options =
                new FirebaseRecyclerOptions.Builder<ItemModel>()
                        .setQuery(refDB, new SnapshotParser<ItemModel>() {
                            @NonNull
                            @Override
                            public ItemModel parseSnapshot(@NonNull DataSnapshot snapshot) {
                                ItemModel item = snapshot.getValue(ItemModel.class);
                                item.setKey(snapshot.getKey());
                                return item;
                            }
                        })
                        .build();

        FirebaseRecyclerAdapter<ItemModel, ItemUpDelAdapter> adapter=
                new FirebaseRecyclerAdapter<ItemModel, ItemUpDelAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ItemUpDelAdapter holder, int position, @NonNull final ItemModel model) {

                        holder.txtPruductName.setText(model.getName());
                        holder.txtProductCode.setText(model.getCode());

                        holder.deleteI.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                deleteItem();
                            }
                        });

                        holder.updateI.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ItemUpdateDelete.this, ItemUpdate.class);
                                intent.putExtra("code", model.getKey());
                                startActivity(intent);
                            }
                        });
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

    private void deleteItem() {
        refDB.child(item.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


                finish();
                Toast.makeText( ItemUpdateDelete.this, "Item deleted successfully!", Toast.LENGTH_SHORT ).show();

            }
        });
    }


}
