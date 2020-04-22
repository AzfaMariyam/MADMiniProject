package com.example.madminiproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewShipPay extends AppCompatActivity {

    Button viewS, viewP;
    ShippingDetHandler db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ship_pay);

        db1 = new ShippingDetHandler(this);


         viewS = findViewById(R.id.viewshipd);
         viewP = findViewById(R.id.viewpayd);

         ViewAllShip();

    }


    public void ViewAllShip(){
        viewS.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = db1.getAllData();
                        if(res.getCount()==0){
                            ShowMessage("Error!!","No  data available!");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :"+ res.getString(0 )+ "\n" );
                            buffer.append("First name :"+ res.getString(1 )+ "\n" );
                            buffer.append("Last name :"+ res.getString(2 )+ "\n" );
                            buffer.append("Address :"+ res.getString(3 )+ "\n" );
                            buffer.append("Country :"+ res.getString(4 )+ "\n" );
                            buffer.append("Postal code :"+ res.getString(5 )+ "\n");
                            buffer.append("Telephone no :"+ res.getString(6 )+ "\n" );
                            buffer.append("Email :"+ res.getString(7 )+ "\n\n" );
                        }
                        ShowMessage("VShipping Details",buffer.toString());
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
