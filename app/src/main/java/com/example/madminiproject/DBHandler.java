package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //defining database
  //  public static final String Database_Name = "eHanger.db3";

 /*   public static final String TABLE_NAME = "shippingDetails";
    public static final String Col_1 = "ShipID";
    public static final String Col_2 = "FirstName";
    public static final String Col_3 = "LastName";
    public static final String Col_4 = "Address";
    public static final String Col_5 = "Country";
    public static final String Col_6 = "PostalCode";
    public static final String Col_7 = "TelNo";
    public static final String Col_8 = "Email";
*/
  /*  public static final String TABLE_NAME = "newShip";
    public static final String Col_1 = "ShipID";
    public static final String Col_2 = "FirstName";
    public static final String Col_3 = "LastName";
    public static final String Col_4 = "Address";
    public static final String Col_5 = "Country";
    public static final String Col_6 = "PostalCode";
    public static final String Col_7 = "TelNo";
    public static final String Col_8 = "Email";


*/




    @Override
    public void onCreate(SQLiteDatabase db) {

    //    db.execSQL("CREATE TABLE " + TABLE_NAME + " (ShipID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Address TEXT, Country TEXT, PostalCode INTEGER, TelNo INTEGER, Email TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      //  onCreate(db);

    }

/*
    public boolean addShip(String fname, String lname, String address, String country, String pcode, String telno, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, fname);
        contentValues.put(Col_3, lname);
        contentValues.put(Col_4, address);
        contentValues.put(Col_5, country);
        contentValues.put(Col_6, Integer.parseInt(pcode));
        contentValues.put(Col_7, Integer.parseInt(telno));
        contentValues.put(Col_8, email);

       long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else
            return true;
    }*/
}
