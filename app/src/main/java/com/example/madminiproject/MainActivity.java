package com.example.madminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PromoDBHelper mydb;

    Button b4 , viewallData1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewallData1 = findViewById(R.id.prom);
        b4 = findViewById(R.id.button4);
        mydb = new PromoDBHelper(this);

        ViewAll1();

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, itemDisplay.class);
                startActivity(i);
            }
        });


    }
    public void ViewAll1(){
        viewallData1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllData1();
                        if(res.getCount()==0){
                            ShowMessage("Error!!","Nothing Found!!");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){

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
