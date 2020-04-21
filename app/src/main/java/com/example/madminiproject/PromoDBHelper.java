package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PromoDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Promo.db" ;
    public static final String Table_Name = "promotions" ;
    public static final String Col_1 = "ID" ;
    public static final String Col_2 = "promotion" ;
    public static final String Col_3= "category";
    public static final String Col_4 = "promocode";

    public PromoDBHelper( Context context) {
        super(context, "Promo.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,promotion TEXT,category TEXT,promocode TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Table_Name );
            onCreate(db);
    }

    public boolean insertData(String promotion,String category,String promocode){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,promotion);
        contentValues.put(Col_3,category);
        contentValues.put(Col_4,promocode);

        long results = db.insert(Table_Name,null,contentValues);
        if (results== -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_Name,null);
        return  res;
    }


}
