package com.fo4ik.formom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String NAME_DATABASE = "config";
    public static final String NAME_TABLE = "data";
    public static final int VERSION_DATABASE = 1;
    public static final String KEY_SURFACE = "surface";
    public static final String KEY_LAKME = "lakme";
    public static final String KEY_POWDER = "powder";
    public static final String KEY_OXI = "oxi";
    public static final String KEY_EXPENSE = "expense";

    public DBHelper(@Nullable Context context) {
        super(context, NAME_DATABASE, null, VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAME_TABLE + " ("
                + KEY_SURFACE + " text, "
                + KEY_LAKME + " text, "
                + KEY_POWDER + " text, "
                + KEY_OXI + " text, "
                + KEY_EXPENSE + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + NAME_TABLE);
        onCreate(db);


    }



}
