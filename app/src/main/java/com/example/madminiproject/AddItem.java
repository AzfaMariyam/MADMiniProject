package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddItem extends AppCompatActivity {

    private TextView code, date, name, price, description, quantity, color;
    private Button addItem, addImg;
    Spinner spinnerS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        code = (EditText) findViewById(R.id.editText4);
        date = (EditText) findViewById(R.id.editText6);
        name = (EditText) findViewById(R.id.editText);
        price = (EditText) findViewById(R.id.editText3);
        description = (EditText) findViewById(R.id.editText5);
        color = (EditText) findViewById(R.id.editText1);
        quantity = (EditText) findViewById(R.id.editText8);

        addItem = (Button) findViewById(R.id.button2);
        addImg = findViewById(R.id.button3);

        spinnerS  = findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddItem.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sizes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(myAdapter);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

}
