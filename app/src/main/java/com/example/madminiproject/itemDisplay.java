package com.example.madminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class itemDisplay extends AppCompatActivity {
    //Button b1;
    //PromoDBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

        //b1 = findViewById(R.id.button13);
        //viewAllpromo();


    }
    /*public void viewAllpromo(){
        b1.setOnClickListener(
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
                            //buffer.append("Id :"+ res.getString(0 )+ "\n" );
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
    }*/

}
