package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PurchaseConfirmation extends AppCompatActivity {

    Button purchconf;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_confirmation);


        purchconf = findViewById(R.id.confirmpay);
        cancel = findViewById(R.id.cancelorder);

        purchconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PurchaseConfirmation.this, Finalpg.class);
                startActivity(continueIntent);
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PurchaseConfirmation.this, MainActivity.class);
                startActivity(continueIntent);
            }
        });
    }
}
