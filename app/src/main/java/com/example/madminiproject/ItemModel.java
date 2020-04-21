package com.example.madminiproject;

import android.provider.BaseColumns;

public final class ItemModel implements BaseColumns {
    private ItemModel() {
    }

    public static class Item implements BaseColumns {
        public static final String TABLE_NAME = "item";
        public static final String COL_CODE = "code";
        public static final String COL_DATE = "date";
        public static final String COL_NAME = "name";
        public static final String COL_PRICE = "price";
        public static final String COL_DES = "description";
        public static final String COL_COLOR = "color";
        public static final String COL_SIZE = "size";
        public static final String COL_QTY = "qty";
    }

}
