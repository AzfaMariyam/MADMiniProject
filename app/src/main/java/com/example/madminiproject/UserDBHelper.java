package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db" ;
    public static final String Table_Name = "users" ;
    public static final String Col_1 = "ID" ;
    public static final String Col_2 = "email" ;
    public static final String Col_3= "password";


    public UserDBHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }

   /* public boolean insert(String email, String password){
        // gets the data in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        //create a new map of values, where column names in key

        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);


        //insert anew row and returning the primary key values tof the new row
        long ins = db.insert("Table_Name", null,values);
        if(ins==-1) return false;
        else return true;


    }
    public Boolean checkemail(String email) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email =?",new String[]{email});
        if (cursor.getCount() >0) return false;
        else return true;
    }*/

}
