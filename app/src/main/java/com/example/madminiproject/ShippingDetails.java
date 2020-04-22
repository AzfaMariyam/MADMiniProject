package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShippingDetails extends AppCompatActivity {

    private Button btnSave;
    private Button cancelb1;

    EditText fname, lname, address, country, pcode, tel, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_details);


        //   newdb = new NewDbHandler(this);

        //mydb = new DBHandler(this);
        //newdb = new NewDbHandler(this);


        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        address = findViewById(R.id.addr);
        country = findViewById(R.id.country);
      pcode = findViewById(R.id.pcode);
        tel = findViewById(R.id.telno);
        email = findViewById(R.id.email);
        btnSave = (Button) findViewById(R.id.savebtn);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ShippingDetHandler newdb = new ShippingDetHandler(getApplicationContext());
                long newID = newdb.addInfo(fname.getText().toString(), lname.getText().toString(), address.getText().toString(), country.getText().toString(), pcode.getText().toString(), tel.getText().toString(), email.getText().toString());
                Toast.makeText(ShippingDetails.this, "Shipping Details saved!    Shipping ID: " + newID, Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), PaymentDetails.class);
                startActivity(i);
                fname.setText(null);
                lname.setText(null);
                address.setText(null);
                country.setText(null);
                pcode.setText(null);
                tel.setText(null);
                email.setText(null);


            }
        });

    }

}
