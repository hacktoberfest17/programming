package com.example.luisyao.lab_8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ClaseSQLiteBD1 extends SQLiteOpenHelper{
    public static final String DataBaseName="Estudiantes.db";
    public static final int dbversion=1;

    public ClaseSQLiteBD1(Context context, String name, CursorFactory factory,
                          int version) {
        super(context, DataBaseName, factory, dbversion);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //se ejecuta la primera vez para crear la BD
        db.execSQL("Create table contacto (_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, CORREO TEXT, NÚMERO TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacto;");
        onCreate(db);
    }

    public List<contact> getAllcontact(){
        List <contact> list_contact = new ArrayList<contact>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from contacto order by NOMBRE asc", null);

        if(cursor.moveToFirst()) {
            do{
                contact contact = new contact();
                contact.id = Integer.parseInt(cursor.getString(0));
                contact.name = cursor.getString(1);
                contact.email = cursor.getString(2);
                contact.phone = cursor.getString(3);
                list_contact.add(contact);

            }while(cursor.moveToNext());

        }
        return list_contact;
    }


}

