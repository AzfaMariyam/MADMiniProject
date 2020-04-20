package com.example.madminiproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {


    //defining database
    public static final String DATABASE_NAME = "eHanger.db3";



    public DBHandler(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + ItemsMaster.Items.TABLE_NAME + " (" +
                ItemsMaster.Items._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ItemsMaster.Items.COLUMN_NAME_DATE + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_NAME + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_PRICE + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_DESCRIPTION + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_COLOR + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_SIZE + " TEXT, " +
                ItemsMaster.Items.COLUMN_NAME_QUANTITY + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + ItemsMaster.Items.TABLE_NAME);
        onCreate(db);
    }

    public void addInfo (String date, String name, String price, String description, String color, String size, String qty) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemsMaster.Items.COLUMN_NAME_DATE, date);
        values.put(ItemsMaster.Items.COLUMN_NAME_NAME, name);
        values.put(ItemsMaster.Items.COLUMN_NAME_PRICE, price);
        values.put(ItemsMaster.Items.COLUMN_NAME_DESCRIPTION, description);
        values.put(ItemsMaster.Items.COLUMN_NAME_COLOR, color);
        values.put(ItemsMaster.Items.COLUMN_NAME_SIZE, size);
        values.put(ItemsMaster.Items.COLUMN_NAME_QUANTITY, qty);

        long newRowId = db.insert(ItemsMaster.Items.TABLE_NAME, null, values);

    }
}
