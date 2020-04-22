package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class itemAdmin extends AppCompatActivity {

    private Button b1, b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_admin);

        b1 = findViewById(R.id.addI);
        b2 = findViewById(R.id.updateI);
        b3 = findViewById(R.id.deleteI);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(itemAdmin.this, AddItem.class);
                startActivity(i);
            }
        });

    }
}
