package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    DBHandler db;
    EditText uname,uemail,upass,ucpass;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new DBHandler( this);

        uname =(EditText) findViewById(R.id.username1);
        uemail = (EditText) findViewById(R.id.email1);
        upass = (EditText) findViewById(R.id.password3);
        ucpass = (EditText) findViewById(R.id.cpassword);
        submit = (Button) findViewById(R.id.button5);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = uname.getText().toString();
                String a2 = uemail.getText().toString();
                String a3 = upass.getText().toString();
                String a4 = ucpass.getText().toString();

                if(a2.equals("") || a1.equals("") || a3.equals("") || a4.equals("")){
                    Toast.makeText(getApplicationContext(),"Feilds are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(a3.equals(a4)){
                        Boolean checkemail = db.checkemail(a2);
                        if(checkemail==true) {
                            Boolean insert = db.insert(a1,a2,a3,a4);
                            if(insert == true) {
                                Toast.makeText(getApplicationContext(),"Rejistered Succuessfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
