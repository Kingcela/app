package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(userName text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    // inserting in the database.
    public boolean insert(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userInformation = new ContentValues();
        userInformation.put("userName", user);
        userInformation.put("password", password);
        long ins = db.insert("user", null, userInformation);
        if (ins == -1) {
            return false;
        }
        return true;
    }
    // check if the user already exist in the database.
    public boolean checkUserName(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where userName = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return false;
        }
        return true;
    }
    //check the user and password for login.
    public boolean userNameAndPassword(String userName, String passWord) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where uerName = ? and password = ?", new String[] {userName, passWord});
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }
}
