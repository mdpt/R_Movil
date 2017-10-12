package com.example.mdpt.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mdpt.sqlite.utilidades.utilidades;

/**
 * Created by MDPT on 10/10/2017.
 */

public class ConexioSqliteHelper extends SQLiteOpenHelper {
    final String CREAR_TABLA_CONTACTO="CREATE TABLE contactos(id INTEGER, nombre TEXT, correo TEXT)";

    public ConexioSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(utilidades.CREAR_TABLA_CONTACTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);
    }
}
