package com.example.madminiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ItemUpdate extends AppCompatActivity {

    private Button update;
    private EditText name, price, description;
    private ImageView image;
    private String itemId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_update);

        itemId = getIntent().getStringExtra("code");
        update = findViewById(R.id.apply_changes_btn);
        name = findViewById(R.id.product_name_maintain);
        price = findViewById(R.id.product_price_maintain);
        description = findViewById(R.id.product_description_maintain);
        image = findViewById(R.id.product_image_maintain);

        getItemDetails(itemId);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyChanges();
            }
        });
    }

    private void applyChanges() {

        String iname = name.getText().toString();
        String iprice = price.getText().toString();
        String ides = description.getText().toString();
//        String iimg = name.getText().toString();

        if (iname.equals("")){
            Toast.makeText(this, "Enter the name of the product", Toast.LENGTH_SHORT).show();
        }
        else if (iprice.equals("")){
            Toast.makeText(this, "Enter the price of the product", Toast.LENGTH_SHORT).show();
        }
        else if (ides.equals("")){
            Toast.makeText(this, "Enter the description of the product", Toast.LENGTH_SHORT).show();
        }
        else{

        }
    }

    private void getItemDetails(String itemId) {
        DatabaseReference itemRef = FirebaseDatabase.getInstance().getReference().child("item");

        itemRef.child(itemId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    ItemModel item = dataSnapshot.getValue(ItemModel.class);

                    String pName = dataSnapshot.child( "name" ).getValue().toString();
                    String pPrice = dataSnapshot.child( "price" ).getValue().toString();
                    String pDescription = dataSnapshot.child( "description" ).getValue().toString();
                    String pImage = dataSnapshot.child( "img" ).getValue().toString();

                    name.setText(pName);
                    price.setText(pPrice);
                    description.setText(pDescription);
                    Picasso.get().load(pImage).into(image);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
