package com.example.administrator.databasedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 10/17/2016.
 */
public class QuanLyUser extends SQLiteOpenHelper{

    static final int D_VERSION =1;     // Version của database
    public QuanLyUser(Context context) {
        super(context, "quanlyuser", null, D_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        create table user
        (
            _id integer primary key autoincrement,
            hoten text,
            sodienthoai text
        )
         */
        String sql="create table user" +
                "( " +
                "_id integer primary key autoincrement, " +
                "hoten text, " +
                "sodienthoai text " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {   // Update table
    /*       db.execSQL("drop table if exists user");
        onCreate(db);*/
    }

    public void taoUser(String hoten,String sodienthoai)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("hoten",hoten);                  //gan 2 gia tri truyen vao
        values.put("sodienthoai", sodienthoai);

        db.insert("user", null, values);    //truyen 2 gia tri vao bang
    }

    public Cursor layUser()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from user",null);        // dung con tro de tro den database va lay du lieu ra
        return c;
    }

    public int soluong()     // dem so dong co trong database
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from user",null);
        return c.getCount();
    }
}
