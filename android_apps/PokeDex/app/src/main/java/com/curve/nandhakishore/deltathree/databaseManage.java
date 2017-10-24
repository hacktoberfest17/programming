package com.curve.nandhakishore.deltathree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nandha Kishore on 03-07-2017.
 */

public class databaseManage {

    private static final String DB_NAME = "DELTA_THREE";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "POKEDEX_HISTORY";
    private static final String C_ID = "ID";
    private static final String C_IMG = "IMAGE";
    private static final String C_NAME = "NAME";
    private String[] allColumns = {C_ID, C_IMG, C_NAME};

    private static final String CREATE_DB = "CREATE TABLE " + TABLE_NAME + "( " + C_ID + " INTEGER PRIMARY KEY, "
            + C_IMG + " TEXT, " + C_NAME + " TEXT);";

    private dbHelper myHelper;
    private final Context myContext;
    private SQLiteDatabase myDatabase;

    public databaseManage (Context c) {
        myContext = c;
    }

    public class dbHelper extends SQLiteOpenHelper {

        public dbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_DB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    public databaseManage open() {
        myHelper = new dbHelper(myContext);
        myDatabase = myHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        myHelper.close();
    }

    public long addRow (historyItem c) {
        ContentValues cv = new ContentValues();
        cv.put(C_ID, c.place);
        if (c.image != null)
            cv.put(C_IMG, c.image.toString());
        else
            cv.put(C_IMG, String.valueOf(c.image));
        cv.put(C_NAME, c.name);
        return myDatabase.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<historyItem> getData() {
        ArrayList<historyItem> list = new ArrayList<>();
        Cursor c = myDatabase.query(TABLE_NAME, allColumns, null, null, null, null, null);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            historyItem row = convertData(c);
            list.add(row);
        }
        c.close();
        return list;
    }

    public void clearData() {
        myDatabase.delete(TABLE_NAME, null, null);
    }

    public void removeRow(historyItem c) {
        int args = c.place;
        myDatabase.delete(TABLE_NAME, C_ID + " = " + args, null);
    }

    private historyItem convertData(Cursor cursor) {
        URL bmp = null;
        try {
            bmp = new URL(cursor.getString(1));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new historyItem(cursor.getInt(0), bmp, cursor.getString(2));
    }
}
