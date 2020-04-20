package com.example.madminiproject;

import android.provider.BaseColumns;

public final class User {

    private User() {}


    /*inner class that defines the table contenet */

    public static class Users implements BaseColumns {

        public static final String Table_Name = "users" ;
        public static final String Column_name_username = "username" ;
        public static final String Column_name_email = "email";
        public static final String Column_name_password = "password";
        public static final String Column_name_cpassword = "cpassword";
    }

}
