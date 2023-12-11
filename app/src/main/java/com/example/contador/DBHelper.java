package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    private static final int DATABASE_VERSION = 2; // Cambia la versión de la base de datos


    public DBHelper(Context context) {
        super(context, "Login.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, monedas TEXT, mejoras TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            MyDB.execSQL("ALTER TABLE users ADD COLUMN monedas TEXT");
            MyDB.execSQL("ALTER TABLE users ADD COLUMN mejoras TEXT");

        } else {
            MyDB.execSQL("DROP TABLE IF EXISTS users");
            onCreate(MyDB);
        }
    }
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users",null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean updatepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("users",contentValues,"username = ?", new String[]{username});
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username =?", new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean actualizarMonedasUsuario(String username, String cantidadMonedas) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("monedas", cantidadMonedas);
        long result = MyDB.update("users", contentValues, "username = ?", new String[]{username});

        return result != -1;
    }
    public boolean actualizarMejorasUsuario(String username, String cantidadMejoras) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mejoras", cantidadMejoras);
        long result = MyDB.update("users", contentValues, "username = ?", new String[]{username});

        return result != -1;
    }
}
