package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ShippingDetHandler extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String Database_NAME = "ShippingDetailstable";

    public ShippingDetHandler(@Nullable Context context) {

        super(context, Database_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_PAY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL((SQL_DELETE_ENTRIES));
        db.execSQL((SQL_DELETE_PAY));
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
//create shipping table
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ShippingTable.ship.TABLE_NAME + " (" +
                    ShippingTable.ship._ID + " INTEGER PRIMARY KEY ," +
                    ShippingTable.ship.COL_1 + " TEXT," +
                    ShippingTable.ship.COL_2 + " TEXT," +
                    ShippingTable.ship.COL_3 + " TEXT," +
                    ShippingTable.ship.COL_4 + " TEXT," +
                    ShippingTable.ship.COL_5 + " TEXT," +
                    ShippingTable.ship.COL_6 + " TEXT," +
                    ShippingTable.ship.COL_7 + " TEXT)";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ShippingTable.ship.TABLE_NAME;


    //add to shipping
    public long addInfo(String FirstName, String LastName, String Address, String Country, String PostalCode, String Telno, String Email) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ShippingTable.ship.COL_1, FirstName);
        values.put(ShippingTable.ship.COL_2, LastName);
        values.put(ShippingTable.ship.COL_3, Address);
        values.put(ShippingTable.ship.COL_4, Country);
        values.put(ShippingTable.ship.COL_5, PostalCode);
        values.put(ShippingTable.ship.COL_6, Telno);
        values.put(ShippingTable.ship.COL_7, Email);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ShippingTable.ship.TABLE_NAME, null, values);

        return newRowId;
    }

    public List readAllInfo(String FirstName) {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                ShippingTable.ship.COL_1,
                ShippingTable.ship.COL_2,
                ShippingTable.ship.COL_3,
                ShippingTable.ship.COL_4,
                ShippingTable.ship.COL_5,
                ShippingTable.ship.COL_6,
                ShippingTable.ship.COL_7
        };



        String selection = ShippingTable.ship.COL_1 + " LIKE ?";
        String[] selectionArgs = { FirstName };


        String sortOrder =
                ShippingTable.ship.COL_1 + " ASC";

        Cursor cursor = db.query(
                ShippingTable.ship.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List ShippingDet = new ArrayList<>();
        while(cursor.moveToNext()) {
            String fname = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_1));
            String lname = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_2));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_3));
            String country = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_4));
            String pcode = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_5));
            String telno = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_6));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(ShippingTable.ship.COL_7));


            ShippingDet.add(fname);
            ShippingDet.add(lname);
            ShippingDet.add(address);
            ShippingDet.add(country);
            ShippingDet.add(pcode);
            ShippingDet.add(telno);
            ShippingDet.add(email);

        }
        cursor.close();
        return ShippingDet;
    }


    public Boolean updateShipping (String FirstName, String LastName, String Address, String Country, String PostalCode, String Telno, String Email){

        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(ShippingTable.ship.COL_2, LastName);
        values.put(ShippingTable.ship.COL_3, Address);
        values.put(ShippingTable.ship.COL_4, Country);
        values.put(ShippingTable.ship.COL_5, PostalCode);
        values.put(ShippingTable.ship.COL_6, Telno);
        values.put(ShippingTable.ship.COL_7, Email);


        // Which row to update, based on the title
        String selection = ShippingTable.ship.COL_1 + " LIKE ?";
        String[] selectionArgs = { FirstName };

        int count = db.update(
                ShippingTable.ship.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >=1 ) {
            return true;
        }
        else {
            return false;
        }

    }


    public void deleteShip (String FirstName){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = ShippingTable.ship.COL_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { FirstName };
        // Issue SQL statement.
        int deletedRows = db.delete(ShippingTable.ship.TABLE_NAME, selection, selectionArgs);


    }

    //get shipping details
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ShippingTable.ship.TABLE_NAME,null);
        return  res;
    }










    //create PAYment table

    private static final String SQL_CREATE_PAY =
            "CREATE TABLE " + PaymentsTable.pay.TABLE_NAME + " (" +
                    PaymentsTable.pay._ID + " INTEGER PRIMARY KEY ," +
                    PaymentsTable.pay.COLM_1 + " TEXT," +
                    PaymentsTable.pay.COLM_2 + " TEXT," +
                    PaymentsTable.pay.COLM_3 + " TEXT," +
                    PaymentsTable.pay.COLM_4 + " TEXT)";


    private static final String SQL_DELETE_PAY =
            "DROP TABLE IF EXISTS " + PaymentsTable.pay.TABLE_NAME;




    //add to shipping
    public long addPayInfo(String cardno, String fullnamec, String expdate, String securitycode) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PaymentsTable.pay.COLM_1, cardno);
        values.put(PaymentsTable.pay.COLM_2, fullnamec);
        values.put(PaymentsTable.pay.COLM_3, expdate);
        values.put(PaymentsTable.pay.COLM_4, securitycode);


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(PaymentsTable.pay.TABLE_NAME, null, values);

        return newRowId;
    }


    public List readAllPayInfo(String fullnamec) {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                PaymentsTable.pay.COLM_1,
                PaymentsTable.pay.COLM_2,
                PaymentsTable.pay.COLM_3,
                PaymentsTable.pay.COLM_4
        };



        String selection = PaymentsTable.pay.COLM_1 + " LIKE ?";
        String[] selectionArgs = { fullnamec };


        String sortOrder =
                PaymentsTable.pay.COLM_1 + " ASC";

        Cursor cursor = db.query(
                PaymentsTable.pay.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List PaymentDet = new ArrayList<>();
        while(cursor.moveToNext()) {
            String cardno = cursor.getString(cursor.getColumnIndexOrThrow(PaymentsTable.pay.COLM_1));
            String fulln = cursor.getString(cursor.getColumnIndexOrThrow(PaymentsTable.pay.COLM_2));
            String expdate = cursor.getString(cursor.getColumnIndexOrThrow(PaymentsTable.pay.COLM_3));
            String securityc = cursor.getString(cursor.getColumnIndexOrThrow(PaymentsTable.pay.COLM_4));

            PaymentDet.add(cardno);
            PaymentDet.add(fulln);
            PaymentDet.add(expdate);
            PaymentDet.add(securityc);


        }
        cursor.close();
        return PaymentDet;
    }


    public Boolean updatePaymentDet (String cardno, String fullnamec, String expdate, String securitycode){

        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(PaymentsTable.pay.COLM_1, cardno);
        values.put(PaymentsTable.pay.COLM_3, expdate);
        values.put(PaymentsTable.pay.COLM_4, securitycode);



        // Which row to update, based on the title
        String selection = PaymentsTable.pay.COLM_2 + " LIKE ?";
        String[] selectionArgs = { fullnamec };

        int count = db.update(
                PaymentsTable.pay.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >=1 ) {
            return true;
        }
        else {
            return false;
        }

    }


    public void deletePaym (String fullnamec){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = PaymentsTable.pay.COLM_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { fullnamec };
        // Issue SQL statement.
        int deletedRows = db.delete(PaymentsTable.pay.TABLE_NAME, selection, selectionArgs);


    }

    //get shipping details
    public Cursor getAllPayData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+PaymentsTable.pay.TABLE_NAME,null);
        return  res;
    }





}
