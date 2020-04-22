package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddItem extends AppCompatActivity {
    private static final String TAG = "AddItem";

    TextView code, date, name, price, description, quantity, color;
    Button addItem, addImg;
    Spinner size;
    DatePickerDialog.OnDateSetListener DataSetListner1;
    DatabaseReference refDB;

    private void clearControls(){
        code.setText("");
        date.setText("");
        name.setText("");
        price.setText("");
        description.setText("");
        quantity.setText("");
        color.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        code = (EditText) findViewById(R.id.editText4);
        date = (TextView) findViewById(R.id.editText6);
        name = (EditText) findViewById(R.id.editText);
        price = (EditText) findViewById(R.id.editText3);
        description = (EditText) findViewById(R.id.editText5);
        color = (EditText) findViewById(R.id.editText1);
        quantity = (EditText) findViewById(R.id.editText8);

        addItem = (Button) findViewById(R.id.button2);
        addImg = findViewById(R.id.button3);

        size  = (Spinner)findViewById(R.id.spinner);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddItem.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        DataSetListner1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DataSetListner1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Log.d(TAG, "OnDateSet:mm/dd/yyyy:" + month + "/" + day + "/" + year);

                String cdate = month + "/" + day + "/" + year;
                date.setText(cdate);


            }
        };

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddItem.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sizes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(myAdapter);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refDB = FirebaseDatabase.getInstance().getReference().child("item");
                try {
                    if(TextUtils.isEmpty(code.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter the item code" , Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter the item name" , Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(price.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter the item price" , Toast.LENGTH_SHORT).show();
                    else {
                        //take inputs from admin n assigning them
                        ItemModel item = new ItemModel(code.getText().toString(), date.getText().toString(), name.getText().toString(), price.getText().toString(), description.getText().toString(), color.getText().toString(), size.getSelectedItem().toString(), Integer.parseInt(quantity.getText().toString()));

                        //inserting to db
                        refDB.push().setValue(item);

                        Toast.makeText(getApplicationContext(), "Item added successfully!" , Toast.LENGTH_SHORT).show();
                        clearControls();

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Invalid entry" , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
