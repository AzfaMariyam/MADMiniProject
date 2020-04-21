package com.example.madminiproject;

import android.provider.BaseColumns;

public class ShippingTable {

    public ShippingTable() {
    }

    public static class ship implements BaseColumns{

        public static final String TABLE_NAME = "newship";
        public static final String COL_1 = "Firstname";
        public static final String COL_2 = "Lastname";
        public static final String COL_3 = "Address";
        public static final String COL_4 = "Country";
        public static final String COL_5 = "PostalCode";
        public static final String COL_6 = "Telno";
        public static final String COL_7 = "Email";
    }

}
