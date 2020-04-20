package com.example.madminiproject.Database;

import android.provider.BaseColumns;

public final class ItemsMaster {
    private ItemsMaster() {
    }

    public static class Items implements BaseColumns {
        public static final String TABLE_NAME = "items";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_COLOR = "color";
        public static final String COLUMN_NAME_SIZE = "size";
        public static final String COLUMN_NAME_QUANTITY = "qty";
    }
}
