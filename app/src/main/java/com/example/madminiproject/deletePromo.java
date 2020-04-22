package com.example.madminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class deletePromo extends AppCompatActivity {

    PromoDBHelper mydb;
    EditText e4,e5,e7,e6;
    Button DelData,viewall,UpdData,findId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_promo);

        viewall = findViewById(R.id.viewall2);

        mydb = new PromoDBHelper(this);

        e4 = findViewById(R.id.promodep2);
        e5 = findViewById(R.id.cat3);
        e7 = findViewById(R.id.promocode2);
        e6 = findViewById(R.id.findid);
        DelData = findViewById(R.id.deletepromo);
        UpdData = findViewById(R.id.updatepromo);
        findId = findViewById(R.id.btnid);
        alldata();

        //find data by id

        findId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PromoDBHelper pbhelper = new PromoDBHelper(getApplicationContext());
                List promocode = pbhelper.readAllInfo(e6.getText().toString());

                if (promocode.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No Promotions added", Toast.LENGTH_SHORT).show();
                    e6.setText(null);
                } else {

                    Toast.makeText(getApplicationContext(), "promotion found" + promocode.get(0).toString(), Toast.LENGTH_SHORT).show();
                    e6.setText(promocode.get(0).toString());
                    e4.setText(promocode.get(1).toString());
                    e5.setText(promocode.get(2).toString());
                    e7.setText(promocode.get(3).toString());


                }
            }
        });


        //Update data

        UpdData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PromoDBHelper pbhelper = new PromoDBHelper(getApplicationContext());
                Boolean status = pbhelper.updateInfo(e6.getText().toString(), e4.getText().toString(), e5.getText().toString(), e7.getText().toString());
                if (status) {
                    Toast.makeText(getApplicationContext(), "Promotion details Details Updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), AddPromo.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Promotion details Update Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });

        DelData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PromoDBHelper pbhelper = new PromoDBHelper(getApplicationContext());
                Boolean status = pbhelper.deleteInfo(e6.getText().toString());

                if (status){
                Toast.makeText(getApplicationContext(), "Promotion Details Deleted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), AddPromo.class);
                startActivity(i);}

                else{
                    Toast.makeText(getApplicationContext(), "Promotion details Delete Failed", Toast.LENGTH_SHORT).show();
                }

                e6.setText(null);
                e4.setText(null);
                e5.setText(null);
                e7.setText(null);

            }
        });
    }
       public void alldata(){

           viewall.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Cursor res = mydb.getAllData();
                   if(res.getCount()==0){
                       ShowMessage("Error!!","Nothing Found!!");
                       return;
                   }

                   StringBuffer buffer = new StringBuffer();
                   while(res.moveToNext()){
                       buffer.append("Id :"+ res.getString(0 )+ "\n" );
                       buffer.append("Promotion:"+ res.getString(1 )+ "\n" );
                       buffer.append("Category :"+ res.getString(2 )+ "\n" );
                       buffer.append("Promo Code:"+ res.getString(3 )+ "\n\n" );

                   }
                   ShowMessage("Promotion Details",buffer.toString());
               }
                                      }
           );
       }

    public  void ShowMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

               }







