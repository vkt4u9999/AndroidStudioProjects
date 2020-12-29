package com.vkt4u9999.clubolympus.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OlympusDatabaseHelper extends SQLiteOpenHelper {
    public OlympusDatabaseHelper(Context context) {
        super(context, ClubOlympusContract.MemberEntry.DATABASE_NAME, null, ClubOlympusContract.MemberEntry.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_MEMBERS_TABLE = "CREATE TABLE " + ClubOlympusContract.MemberEntry.TABLE_NAME + "("
                + ClubOlympusContract.MemberEntry._ID + " INTEGER PRIMARY KEY,"
                + ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME + " TEXT,"
                + ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME + " TEXT,"
                + ClubOlympusContract.MemberEntry.COLUMN_GENDER + " INTEGER NOT NULL,"
                + ClubOlympusContract.MemberEntry.COLUMN_SPORT + " TEXT" + ")";


        sqLiteDatabase.execSQL(CREATE_MEMBERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ClubOlympusContract.MemberEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
