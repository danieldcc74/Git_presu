package com.example.presureforms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDDSQL extends SQLiteOpenHelper {

    final String TABLE_CLIENTE="CREATE TABLE clientes(id INTEGET,nombre TEXT,apellidos TEXT, domicilio TEXT, localidad, cp TEXT)";

    public BBDDSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(TABLE_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXTIST clientes");
        onCreate(db);
    }
}
