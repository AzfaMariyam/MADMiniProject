package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class OrderSummary extends AppCompatActivity {

    private  String grandTotal = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        grandTotal = getIntent().getStringExtra("Grand Total");
        Toast.makeText(this, " Grand Total = LKR " + grandTotal, Toast.LENGTH_SHORT).show();
    }
}
