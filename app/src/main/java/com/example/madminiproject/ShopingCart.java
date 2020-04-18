package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopingCart extends AppCompatActivity {

    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderSummary();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateCart();
            }
        });
    }

    public void openOrderSummary(){
        Intent intent = new Intent(this,OrderSummary.class);
        startActivity(intent);
    }

    public void openUpdateCart(){
        Intent intent1 = new Intent(this,UpdateCart.class);
        startActivity(intent1);
    }
}
