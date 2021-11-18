package com.example.enigmassiette;

import android.provider.BaseColumns;

public class WaitlistContract {

    public static final class WaitlistEntry implements BaseColumns{

        public static final String TABLE_NAME = "note";
        public static final String COLUMN_RESTAU_NAME = "restaurantName";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_NOTE_DECO = "noteDeco";
        public static final String COLUMN_NOTE_FOOD = "noteFood";
        public static final String COLUMN_NOTE_SERV = "noteServ";
        public static final String COLUMN_NOTE_CRITIQUE = "critique";
    }
}
