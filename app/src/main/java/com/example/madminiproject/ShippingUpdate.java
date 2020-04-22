package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ShippingUpdate extends AppCompatActivity {
    EditText fname, lname, address, country, pcode, tel, email;
    EditText search;
    Button save, del, searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_update);

        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        address = findViewById(R.id.addr);
        country = findViewById(R.id.country);
        pcode = findViewById(R.id.pcode);
        tel = findViewById(R.id.telno);
        email = findViewById(R.id.email);
        search = findViewById(R.id.shipsearch);

        save = findViewById(R.id.updateshipbtn);
        del = findViewById(R.id.delship);
        searchbtn = findViewById(R.id.searchShip);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShippingDetHandler newdb = new ShippingDetHandler(getApplicationContext());

                List firstN = newdb.readAllInfo(search.getText().toString());

                if (firstN.isEmpty()){
                    Toast.makeText(ShippingUpdate.this, "No Details", Toast.LENGTH_SHORT).show();
                    search.setText(null);
                }
                else {

                    Toast.makeText(ShippingUpdate.this, "Details Found! Details: "+firstN.get(0).toString(), Toast.LENGTH_SHORT).show();
                    search.setText(firstN.get(0).toString());
                    lname.setText(firstN.get(1).toString());
                    address.setText(firstN.get(2).toString());
                    country.setText(firstN.get(3).toString());
                    pcode.setText(firstN.get(4).toString());
                    tel.setText(firstN.get(5).toString());
                    email.setText(firstN.get(6).toString());


                }

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShippingDetHandler newdb = new ShippingDetHandler(getApplicationContext());

                Boolean status = newdb.updateShipping(search.getText().toString(),lname.getText().toString(),address.getText().toString(),country.getText().toString(), pcode.getText().toString(),tel.getText().toString(),email.getText().toString() );
                if (status){
                    Toast.makeText(ShippingUpdate.this, "Shipping Details Updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),PaymentDetails.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(ShippingUpdate.this, "Shipping details update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShippingDetHandler det = new ShippingDetHandler(getApplicationContext());
                det.deleteShip(search.getText().toString());

                Toast.makeText(ShippingUpdate.this, "Shipping Details Deleted", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),PaymentDetails.class);
                startActivity(i);

                search.setText(null);
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
