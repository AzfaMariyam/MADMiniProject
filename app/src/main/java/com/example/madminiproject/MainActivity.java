package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b4 = findViewById(R.id.button4);
        b4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItemDisplay();
            }
        }));
    }


    public void openItemDisplay(){

       // Intent i1 = new Intent(this,itemDisplay.class);
        Intent i1 = new Intent(this, itemDisplay.class);
        startActivity(i1);
    }


}
