package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShippingDetails extends AppCompatActivity {

    private Button btnSave;
    private Button cancelb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_details);

        btnSave = (Button) findViewById(R.id.savebtn);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPaymentDetails();

            }
        });

    }


    public void openPaymentDetails(){

        Intent intent1 = new Intent(this,PaymentDetails.class);
        startActivity(intent1);

    }

}
