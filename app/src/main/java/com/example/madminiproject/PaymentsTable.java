package com.example.madminiproject;

import android.provider.BaseColumns;

public class PaymentsTable {

    public PaymentsTable() {
    }


    public static class pay implements BaseColumns{

        public static final String TABLE_NAME = "PaymentDets";
        public static final String COLM_1 = "CardNo";
        public static final String COLM_2 = "FullNameC";
        public static final String COLM_3 = "ExpiryDate";
        public static final String COLM_4 = "SecurityCode";

    }

}
