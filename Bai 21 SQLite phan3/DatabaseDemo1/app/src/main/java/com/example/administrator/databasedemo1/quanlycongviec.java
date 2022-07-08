package com.example.administrator.databasedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/19/2016.
 */
public class quanlycongviec extends SQLiteOpenHelper{
    public quanlycongviec(Context context) {
        super(context, "qlcv", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        create table congviec (
            _id integer primary key autoincrement,
            noidung text,
            thoigian text
        )
        */

        String sql="create table congviec ( " +
                "_id integer primary key autoincrement, " +
                "noidung text, " +
                "thoigian text " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.rawQuery("drop table if exists qlcv",null);
        onCreate(db);
    }

    public ArrayList<CongViec> layCongViec()    // Tạo ArrayList cho ListView
    {
        SQLiteDatabase db=this.getReadableDatabase();     //Đọc Database
        Cursor c= db.rawQuery("select * from congviec", null);

        ArrayList<CongViec> ds=new ArrayList<CongViec>();

        if(c.moveToFirst())
        {
            do{
                int _id=c.getInt(0);
                String noidung=c.getString(1);
                String thoigian=c.getString(2);

                CongViec cv=new CongViec(_id,noidung,thoigian);    // Lấy ra Contrustor 3 tham số và add vào ArrayList
                ds.add(cv);
            }while(c.moveToNext());
        }

        return ds;  // Trả về ArrayList
    }

    public void themCongViec(CongViec c) {
        SQLiteDatabase db=this.getWritableDatabase();    //Ghi Database
        ContentValues values=new ContentValues();
        values.put("noidung",c.noidung);
        values.put("thoigian",c.thoigian);
        db.insert("congviec",null,values);

    }

    public void xoaCongViec(int id) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("congviec", "_id=?", new String[]{id + ""});

    }

    public void suaCongViec(CongViec c) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("noidung",c.noidung);
        values.put("thoigian",c.thoigian);
        db.update("congviec",values,"_id=?",new String[]{c._id+""});
    }
}
