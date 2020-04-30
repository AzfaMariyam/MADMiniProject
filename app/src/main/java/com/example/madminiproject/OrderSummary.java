package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OrderSummary extends AppCompatActivity {

    private TextView total;
    private  String grandTotal = "";
    private Button backTo;
    private Button shipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        grandTotal = getIntent().getStringExtra("Grand Total");

        backTo = (Button) findViewById(R.id.backto);
        backTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSummary.this, ShopingCart.class);
                startActivity(intent);
            }
        });


        shipment = (Button) findViewById(R.id.shipment);
        shipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSummary.this, ShippingDetails.class);
                startActivity(intent);
            }
        });

        total = (TextView) findViewById(R.id.gtotal);
        total.setText(" Grand Total : " + String.valueOf(grandTotal));


    }
}
