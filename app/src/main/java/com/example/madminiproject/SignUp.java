package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText uname,uemail,upass,ucpass;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        uname =(EditText) findViewById(R.id.username1);
        uemail = (EditText) findViewById(R.id.email1);
        upass = (EditText) findViewById(R.id.password1);
        ucpass = (EditText) findViewById(R.id.cpass);
        submit = (Button) findViewById(R.id.button5);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = uname.getText().toString();
                String a2 = uemail.getText().toString();
                String a3 = upass.getText().toString();
                String a4 = ucpass.getText().toString();

            }
        });
    }
}
