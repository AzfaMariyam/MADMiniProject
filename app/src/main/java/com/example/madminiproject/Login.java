package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button b1, b2, b3;
    EditText d1, d2;
    UserDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserDBHelper(this);
        d1 = findViewById(R.id.username);
        d2 = findViewById(R.id.password);


        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button11);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpass();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = d1.getText().toString();
                String pass = d2.getText().toString();


                UserDBHelper db = new UserDBHelper(getApplicationContext());
                Boolean checkmailpass = db.emailpassword(email, pass);


                if(email.equals("admin@gmail.com")){

                    Toast.makeText(Login.this, "Logged into Admin Panel !", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),AdminPanel.class);
                    startActivity(i);
                }

                else if (checkmailpass==true){
                    Toast.makeText(getApplicationContext(), "Successfully Logged in !", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void opensignup() {
        Intent i1;
        i1 = new Intent(this, SignUp.class);
        startActivity(i1);
    }

    public void openpass() {
        Intent i1;
        i1 = new Intent(this, ForgotPassword.class);
        startActivity(i1);
    }

    public void openmain() {
        Intent i1;
        i1 = new Intent(this, MainActivity.class);
        startActivity(i1);
    }
}

