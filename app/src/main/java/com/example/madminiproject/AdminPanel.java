package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanel extends AppCompatActivity {

    Button s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        s1 = findViewById(R.id.additems2);
        s2 = findViewById(R.id.addpromo1);
        s3 = findViewById(R.id.shipping);



        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openadditem();
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddpromo();
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshipping();
            }
        });

    }




    public void  openadditem(){

        Intent i1;
        i1 = new Intent(this, AddItem.class);
        startActivity(i1);
    }

    public void  openaddpromo(){

        Intent i1;
        i1 = new Intent(this, AddPromo.class);
        startActivity(i1);
    }

    public void openshipping(){
        Intent i1;
        i1 = new Intent(this, ViewShipPay.class);
        startActivity(i1);

    }

}
