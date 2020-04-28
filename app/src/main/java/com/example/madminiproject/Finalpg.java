package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finalpg extends AppCompatActivity {

    Button backtohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpg);

        backtohome = findViewById(R.id.backhome);

        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent continueIntent = new Intent(Finalpg.this, MainActivity.class);
                startActivity(continueIntent);
            }
        });

    }
}
