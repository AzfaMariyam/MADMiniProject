package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPromo extends AppCompatActivity {

    PromoDBHelper mydb;

    EditText e1,e2,e3;
    Button AddData,viewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promo);

        viewAll= findViewById(R.id.viewall);
        viewAll.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAll();
            }
        }));
        mydb = new PromoDBHelper(this);

        e1 = findViewById(R.id.promodep);
        e2 = findViewById(R.id.catg);
        e3 = findViewById(R.id.code);
        AddData = findViewById(R.id.submitpromo);
        AddData();
    }

    public void openAll(){

        Intent i1 = new Intent(this,deletePromo.class);
        startActivity(i1);
    }
    public void AddData() {
        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(e1.equals("") ||  e2.equals("") || e3.equals("")){
                    Toast.makeText(getApplicationContext(),"Feilds are empty",Toast.LENGTH_SHORT).show();*/

                boolean isInserted = mydb.insertData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());


                 if (isInserted == true)
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
