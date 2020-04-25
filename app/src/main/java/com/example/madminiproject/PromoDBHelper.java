package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

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



    //insert data to the database

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



    //get all data from the databse


    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_Name,null);
        return  res;
    }


    //use id to get  datas to related to that id


    public List readAllInfo (String ID){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Col_1,
                Col_2,
                 Col_3,
                Col_4,


        };

        // Filter results WHERE "title" = 'My Title'
        String selection = Col_1 + " LIKE ?";
        String[] selectionArgs = {  ID };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Col_1  + " ASC";

        Cursor cursor = db.query(
                Table_Name,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List Promotioninfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String pid = cursor.getString(cursor.getColumnIndexOrThrow( Col_1));
            String pdep = cursor.getString(cursor.getColumnIndexOrThrow(Col_2));
            String pcat = cursor.getString(cursor.getColumnIndexOrThrow(Col_3));
            String pcode= cursor.getString(cursor.getColumnIndexOrThrow(Col_4));

            Promotioninfo.add(pid);//0
            Promotioninfo.add(pdep);//1
            Promotioninfo.add(pcat);//2
            Promotioninfo.add(pcode);//3

        }
        cursor.close();
        return Promotioninfo;
    }

    //update data

    public Boolean updateInfo (String ID,String promotion,String category,String promocode){

        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues contentValues = new ContentValues();

        contentValues.put(Col_2,promotion);
        contentValues.put(Col_3,category);
        contentValues.put(Col_4,promocode);


        // Which row to update, based on the title
        String selection = Col_1 + " LIKE ?";
        String[] selectionArgs = {  ID };

        int count = db.update(
                Table_Name,
                contentValues,
                selection,
                selectionArgs);

        if (count >=1 ) {
            return true;
        }
        else {
            return false;
        }

    }

    //delete data using id

    public Boolean deleteInfo (String ID){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = Col_1+ " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { ID };
        // Issue SQL statement.
        int deletedRows = db.delete( Table_Name, selection, selectionArgs);

        if (deletedRows>=1 ) {
            return true;
        }
        else {
            return false;
        }


    }
    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_Name,null);
        return  res;
    }


}
