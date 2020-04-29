package com.example.madminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPromo extends AppCompatActivity {

    PromoDBHelper mydb;

    EditText e1,e2,e3;
    Button AddData,viewAll,Editp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promo);

        viewAll= findViewById(R.id.viewall);

        mydb = new PromoDBHelper(this);

        e1 = findViewById(R.id.promodep);
        e2 = findViewById(R.id.catg);
        e3 = findViewById(R.id.code);
        AddData = findViewById(R.id.submitpromo);
        Editp = findViewById(R.id.editpromo);
        AddData();
        ViewAll();

        Editp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(AddPromo.this, deletePromo.class);
                startActivity(continueIntent);
            }
        });

    }



    public void AddData() {
        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = mydb.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString());
                if(TextUtils.isEmpty(e1.getText())){
                    e1.setError("Please enter promotion description!");
                    e1.requestFocus();}
                else if(TextUtils.isEmpty(e2.getText())){
                    e2.setError("Please enter categories!");
                    e2.requestFocus(); }
                else if(TextUtils.isEmpty(e3.getText())){
                    e3.setError("Please enter promocode!");
                    e3.requestFocus(); }

                else{if(isInserted == true)
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Data not Inserted", Toast.LENGTH_SHORT).show();
            }}
        });
    }
    public void ViewAll(){
        viewAll.setOnClickListener(
                new View.OnClickListener() {
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
