package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
        btnSave =  findViewById(R.id.savebtn);
        cancelb1 = findViewById(R.id.cancelbtn1);



        cancelb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(ShippingDetails.this, MainActivity.class);
                startActivity(continueIntent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validationg the form
                if(TextUtils.isEmpty(fname.getText())){
                    fname.setError("Please enter First name!");
                    fname.requestFocus();}
                else if(TextUtils.isEmpty(lname.getText())){
                    lname.setError("Please enter last name!");
                    lname.requestFocus(); }
                else if(TextUtils.isEmpty(address.getText())){
                    address.setError("Please enter Address!");
                    address.requestFocus(); }
                else if(TextUtils.isEmpty(country.getText())){
                    country.setError("Please enter your country!");
                    country.requestFocus(); }
                else if(TextUtils.isEmpty(pcode.getText())){
                    pcode.setError("Please enter the postal code!");
                    pcode.requestFocus(); }
                else if(TextUtils.isEmpty(tel.getText())){
                    tel.setError("Please enter your telephone no.!");
                    tel.requestFocus(); }
                else if(TextUtils.isEmpty(email.getText())){
                    email.setError("Please enter your email!");
                    email.requestFocus(); }

                //adding data
                else {

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
            }
        });

    }

}
