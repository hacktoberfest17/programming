package com.example.profilebox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ProfileBox.db";
    public static final String TABLE_NAME = "Profile";
    public static final String C1 = "FN";
    public static final String C2 = "SN";
    public static final String C3 = "Email";
    public static final String C4 = "Country";
    public static final String C5 = "Mobile";
    public static final String C6 = "DD";
    public static final String C7 = "MM";
    public static final String C8 = "YYYY";
    public static final String C9 = "HQ";
    public static final String C10 = "Gender";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + C1 + " TEXT(10) NOT NULL," + C2 + " TEXT(10) NOT NULL, " + C3 + " TEXT(50) PRIMARY KEY NOT NULL," + C4 + " INTEGER NOT NULL," + C5 + " TEXT(10) NOT NULL," + C6 + " INTEGER NOT NULL," + C7 + " INTEGER NOT NULL," + C8 + " INTEGER NOT NULL," + C9 + " INTEGER NOT NULL," + C10 + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C1, v1);
        contentValues.put(C2, v2);
        contentValues.put(C3, v3);
        contentValues.put(C4, v4);
        contentValues.put(C5, v5);
        contentValues.put(C6, v6);
        contentValues.put(C7, v7);
        contentValues.put(C8, v8);
        contentValues.put(C9, v9);
        contentValues.put(C10, v10);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Cursor getSingle(String ss) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+C3+"=?" ,new String[]{ss});

        return res;
    }

    public boolean updateData(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C1, v1);
        contentValues.put(C2, v2);
        contentValues.put(C3, v3);
        contentValues.put(C4, v4);
        contentValues.put(C5, v5);
        contentValues.put(C6, v6);
        contentValues.put(C7, v7);
        contentValues.put(C8, v8);
        contentValues.put(C9, v9);
        contentValues.put(C10, v10);
        db.update(TABLE_NAME, contentValues, "" + C3 + "= ?", new String[]{v3});
        return true;
    }

    public Integer deleteData(String v3) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "" + C3 + " = ?", new String[]{v3});
    }
    public Integer deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,null,null);
    }
}

