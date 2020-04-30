package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentDetails extends AppCompatActivity {

    private Button donebtn;
    private Button editb, cancelbtn;
    private EditText cardn, fullnc, cexpdate, secno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);



        cardn = findViewById(R.id.cardno);
        fullnc = findViewById(R.id.cardfulln);
        cexpdate = findViewById(R.id.expdate);
        secno = findViewById(R.id.seccode);

        donebtn =  findViewById(R.id.done);
        editb = findViewById(R.id.editb);
        cancelbtn = findViewById(R.id.cancelpaybtn);


        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PaymentDetails.this, MainActivity.class);
                startActivity(continueIntent);
            }
        });

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //valadating the form
                if(TextUtils.isEmpty(cardn.getText())){
                    cardn.setError("Please enter card number!");
                    cardn.requestFocus();}
                else if(TextUtils.isEmpty(fullnc.getText())){
                    fullnc.setError("Please enter full name!");
                    fullnc.requestFocus(); }
                else if(TextUtils.isEmpty(cexpdate.getText())){
                    cexpdate.setError("Please enter expiry date!");
                    cexpdate.requestFocus(); }
                else if(TextUtils.isEmpty(secno.getText())){
                    secno.setError("Please enter Security code!");
                    secno.requestFocus(); }

                //add data
                else {
                    ShippingDetHandler newdbp = new ShippingDetHandler(getApplicationContext());
                    long newID = newdbp.addPayInfo(cardn.getText().toString(), fullnc.getText().toString(), cexpdate.getText().toString(), secno.getText().toString());
                    Toast.makeText(PaymentDetails.this, "Added Payment Details successfully!   " , Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(), PurchaseConfirmation.class);
                    startActivity(i);
                    cardn.setText(null);
                    fullnc.setText(null);
                    cexpdate.setText(null);
                    secno.setText(null);
                }
            }
        });


        editb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PaymentDetails.this, ShippingUpdate.class);
                startActivity(continueIntent);
            }
        });

    }




}
