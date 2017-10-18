package com.example.rishabh.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//responsible for maintaining database
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    //name of database
    public static final String TABLE_PRODUCTS="products";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_PRODUCTNAME="productname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE_TABLE"+TABLE_PRODUCTS+"("
                +COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT"
                +COLUMN_PRODUCTNAME+"TEXT"+")";
     db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_PRODUCTS);
        onCreate(db);
    }

    //adding new row to database
    public void addProduct (Products product){
        ContentValues values=new ContentValues();
        values.put(COLUMN_PRODUCTNAME,product.get_productname());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();

    }
    //delete product from database
    public void deleteProduct(String  productName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " +TABLE_PRODUCTS + "WHERE"+COLUMN_PRODUCTNAME+ "=\"" + productName +"\";");
    }

    //print out the database as string
    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_PRODUCTS+"WHERE 1";

        //Cursor point to a location in your result
        Cursor c=db.rawQuery(query,null);
        //Move to first  row in your result
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("productname"))!=null){
                dbString+=c.getString(c.getColumnIndex("productname"));
                dbString+="\n";
            }
        }
        db.close();
        return dbString;
    }
}
