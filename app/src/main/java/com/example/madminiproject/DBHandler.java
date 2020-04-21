package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String Database_NAME = "Ehanger";

    public DBHandler(@Nullable Context context) {

        super(context, Database_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL((SQL_DELETE_ITEM));
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ITEM =
            "CREATE TABLE " + ItemModel.Item.TABLE_NAME + " (" +
                    ItemModel.Item._ID + " INTEGER PRIMARY KEY ," +
                    ItemModel.Item.COL_CODE + " TEXT," +
                    ItemModel.Item.COL_DATE + " TEXT," +
                    ItemModel.Item.COL_NAME + " TEXT," +
                    ItemModel.Item.COL_PRICE + " TEXT," +
                    ItemModel.Item.COL_DES + " TEXT," +
                    ItemModel.Item.COL_COLOR + " TEXT," +
                    ItemModel.Item.COL_SIZE + " TEXT," +
                    ItemModel.Item.COL_QTY + " INTEGER)";

    private static final String SQL_DELETE_ITEM =
            "DROP TABLE IF EXISTS " + ItemModel.Item.TABLE_NAME;

    public long addItems(String code, String date, String name, String price, String description, String color, String size, String qty) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ItemModel.Item.COL_CODE , code);
        values.put(ItemModel.Item.COL_DATE , date);
        values.put(ItemModel.Item.COL_NAME , name);
        values.put(ItemModel.Item.COL_PRICE, price);
        values.put(ItemModel.Item.COL_DES , description);
        values.put(ItemModel.Item.COL_COLOR, color);
        values.put(ItemModel.Item.COL_SIZE , size);
        values.put(ItemModel.Item.COL_COLOR, Integer.parseInt(qty));

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ShippingTable.ship.TABLE_NAME, null, values);

        return newRowId;
    }
}
