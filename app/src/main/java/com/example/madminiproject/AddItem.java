package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddItem extends AppCompatActivity {
    EditText code, date, name, price, description, quantity, color;
    Button addItem, addImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        code = findViewById(R.id.editText4);
        date = findViewById(R.id.editText6);
        name = findViewById(R.id.editText);
        price = findViewById(R.id.editText3);
        description = findViewById(R.id.editText5);
        color = findViewById(R.id.editText1);
        quantity = findViewById(R.id.editText8);

        addItem = findViewById(R.id.button2);
        addImg = findViewById(R.id.button3);

        Spinner spinnerS  = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddItem.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sizes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(myAdapter);
    }
}
