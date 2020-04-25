package com.example.madminiproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.util.Calendar;

public class AddItem extends AppCompatActivity {
    private static final String TAG = "AddItem";


    private ImageView image;
    private static final int GalleryPick = 1;
    private Uri imageUri;
    private StorageReference ProductImgRef;
    String downloadimgUrl;
    TextView code, date, name, price, description, quantity;
    Button addItem;
    ImageButton back;
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
        image.setImageURI(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ProductImgRef = FirebaseStorage.getInstance().getReference().child("ProuctImgs");

        code = (EditText) findViewById(R.id.editText4);
        date = (TextView) findViewById(R.id.editText6);
        name = (EditText) findViewById(R.id.editText);
        price = (EditText) findViewById(R.id.editText3);
        description = (EditText) findViewById(R.id.editText5);
        quantity = (EditText) findViewById(R.id.editText8);

        addItem = (Button) findViewById(R.id.button2);
        image =(ImageView) findViewById(R.id.imageView9);
        back = findViewById(R.id.imageButton4);

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
                        StoreItemImg();
                        //take inputs from admin n assigning them
                        ItemModel item = new ItemModel(
                                code.getText().toString(),
                                date.getText().toString(),
                                name.getText().toString(),
                                price.getText().toString(),
                                description.getText().toString(),
                                size.getSelectedItem().toString(),
                                Integer.parseInt(quantity.getText().toString()),
                                downloadimgUrl
                        );


//                        inserting to db
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AddItem.this, itemAdmin.class);
                startActivity(i);
            }
        });



        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

    }


    private void OpenGallery(){
        Intent galleryi = new Intent();
        galleryi.setAction(Intent.ACTION_GET_CONTENT);
        galleryi.setType("image/*");
        startActivityForResult(galleryi, GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GalleryPick && resultCode==RESULT_OK && data!=null){
            imageUri = data.getData();
            image.setImageURI(imageUri);
        }
    }

    private void StoreItemImg() {
        final StorageReference filePath = ProductImgRef.child(imageUri.getLastPathSegment() + ".jpg");

        final UploadTask uploadTask = filePath.putFile(imageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String messege = e.toString();
                Toast.makeText(AddItem.this, "error" + messege, Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(AddItem.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()){
                            throw task.getException();
                        }

                        downloadimgUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            downloadimgUrl = task.getResult().toString();
                            Toast.makeText(AddItem.this, "Got the product img url successfully", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }


}
