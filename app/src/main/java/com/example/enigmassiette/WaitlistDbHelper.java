package com.example.enigmassiette;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WaitlistDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "note.db";

    private static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE "+ WaitlistContract.WaitlistEntry.TABLE_NAME + "  ("+
                WaitlistContract.WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WaitlistContract.WaitlistEntry.COLUMN_RESTAU_NAME + " TEXT NOT NULL," +
                WaitlistContract.WaitlistEntry.COLUMN_DATE + " DATE NOT NULL,"+
                WaitlistContract.WaitlistEntry.COLUMN_TIME + " TIME NOT NULL,"+
                WaitlistContract.WaitlistEntry.COLUMN_NOTE_DECO + " INTEGER NOT NULL"+
                WaitlistContract.WaitlistEntry.COLUMN_NOTE_FOOD + " INTEGER NOT NULL"+
                WaitlistContract.WaitlistEntry.COLUMN_NOTE_SERV + " INTEGER NOT NULL"+
                WaitlistContract.WaitlistEntry.COLUMN_NOTE_CRITIQUE + " TEXT NOT NULL);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }
}
