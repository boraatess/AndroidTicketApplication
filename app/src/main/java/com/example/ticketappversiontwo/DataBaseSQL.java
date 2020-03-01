package com.example.ticketappversiontwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQL extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "mylist.db";
    private static final String TABLE_NAME = "mylist_data";
    public static final String COL = "ID";
    private static final String COL1 = "ITEM1";
    public static final String COL2 = "EMAIL";
    public static final String COL3 = "PASSWORD";


    public DataBaseSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public boolean addData(String item1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,item1);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
        {

            return false;
        }
        else {

            return true;

        }

    }

    public Cursor getListContents()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);
        return data;


    }
}
