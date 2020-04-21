package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentDetails extends AppCompatActivity {

    private Button donebtn;
    private Button editb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        donebtn = (Button) findViewById(R.id.done);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPurchaseConfirm();
            }
        });

        editb = findViewById(R.id.editb);
        editb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PaymentDetails.this, ShippingUpdate.class);
                startActivity(continueIntent);
            }
        });

    }


    public void openPurchaseConfirm(){

        Intent intent2 = new Intent(this,PurchaseConfirmation.class);
        startActivity(intent2);
    }



}
