package com.example.madminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class ShopingCart extends AppCompatActivity {

    private Button proceed;
    private Button conti;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int grandTotal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shoping_cart);

        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        proceed = (Button) findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent (ShopingCart.this, OrderSummary.class);
                intent.putExtra("Grand Total", String.valueOf(grandTotal));
                startActivity(intent);
                finish();
            }
        });

        conti = (Button) findViewById(R.id.backtoo);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopingCart.this, itemDisplay.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart");

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(cartListRef.child("item"), Cart.class).build();

        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder,  int position, @NonNull final Cart cart) {
                holder. cpName.setText(cart.getPname());
                holder. cpPrice.setText("Price  "+cart.getPrice()+" LKR");
                holder. cpQty.setText("Quantity  "+cart.getQty());


                int oneItemTotal = ((Integer.valueOf(cart.getPrice()))) * Integer.valueOf(cart.getQty());
                grandTotal = grandTotal + oneItemTotal;

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence options[] = new CharSequence[]
                                {
                                        "Edit", "Remove"
                                };
                        AlertDialog.Builder builder = new AlertDialog.Builder(ShopingCart.this);
                        builder.setTitle("Cart Options:");

                        builder.setItems(options,  new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i1) {
                                if (i1 == 0){
                                    Intent intent = new Intent(ShopingCart.this,ItemDetails.class);
                                    intent.putExtra("code",cart.getPcode());
                                    startActivity(intent);

                                }

                                if (i1 == 1){
                                    cartListRef.child("item").child(cart.getPcode()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(ShopingCart.this,"Item is removed successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(ShopingCart.this,itemDisplay.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        builder.show();
                    }
                });
            }

            @NonNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                CartViewHolder holder = new CartViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
//    public void openOrderSummary () {
//        Intent intent = new Intent(this, OrderSummary.class);
//        startActivity(intent);
//    }

//    public void openUpdateCart () {
//        Intent intent1 = new Intent(this, UpdateCart.class);
//        startActivity(intent1);
//    }
}