package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.madminiproject.User.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {


    //defining database
    public static final String Database_Name = "eHanger.db3";



    public DBHandler(@Nullable Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Users.Table_Name + " (" +
                        Users._ID + " INTEGER PRIMARY KEY," +
                        Users.Column_name_username + "TEXT," +
                        Users.Column_name_email  + "TEXT," +
                        Users.Column_name_password + " TEXT" +
                        Users.Column_name_cpassword + "TEXT)" ;

        //use  the deatials from the User and Users classes we created.specify the primary key from the basecolumns

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String userName, String email, String password, String cpassword){
        // gets the data in write mode
        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names in key

        ContentValues values = new ContentValues();
        values.put(Users.Column_name_username, userName);
        values.put(Users.Column_name_email, email);
        values.put(Users.Column_name_password, password);
        values.put(Users.Column_name_cpassword, cpassword);

        //insert anew row and returning the primary key values tof the new row
        long ins = db.insert(Users.Table_Name, null,values);
        if(ins==-1) return false;
        else return true;


    }

    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                Users._ID,
                Users.Column_name_username,
                Users.Column_name_password,
                Users.Column_name_cpassword
        };


        String selection = Users.Column_name_username + " = ?";
        String[] selectionArgs = {""};
        String sortOrder = Users.Column_name_username + " DESC ";

        Cursor cursor = db.query(
                Users.Table_Name,
                projection,
                null,
                null,
                null,
                null,



                sortOrder
        );
        List userNames = new ArrayList<>();
        List emails = new ArrayList<>();
        List passwords = new ArrayList<>();
        List cpasswords = new ArrayList<>();

        while(cursor.moveToNext()) {

            String username = cursor.getString( cursor.getColumnIndexOrThrow(Users.Column_name_username));
            String email = cursor.getString( cursor.getColumnIndexOrThrow(Users.Column_name_email));
            String password = cursor.getString( cursor.getColumnIndexOrThrow(Users.Column_name_password));
            String cpassword = cursor.getString( cursor.getColumnIndexOrThrow(Users.Column_name_cpassword));
            userNames.add(username);
            emails.add(email);
            passwords.add(password);
            cpasswords.add(cpassword);
        }
        cursor.close();
        return userNames;
    }

public void deleteUser(String userName) {

        SQLiteDatabase db = getReadableDatabase();
        String selection = Users.Column_name_username + " LIKE ?";
        String[] selectionArgs = { userName };
        db.delete(Users.Table_Name, selection, selectionArgs);
}

public void updateUser(String userName, String email, String password,String cpassword) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Users.Column_name_password, password);
        values.put(Users.Column_name_cpassword, cpassword);
        values.put(Users.Column_name_email, email);

        String selection = Users.Column_name_username + " LIKE ? ";
        String[] selectionArgs = { userName };

        int count = db.update(
                Users.Table_Name,
                values,
                selection,
                selectionArgs
        );
}

public boolean checkemail(String email) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Users where email=?",new String[]{email});
    if (cursor.getCount() >0) return false;
    else return true;
    }


}




