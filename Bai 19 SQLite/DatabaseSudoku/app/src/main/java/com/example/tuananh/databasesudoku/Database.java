package com.example.tuananh.databasesudoku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tuan Anh on 01/11/2016.
 */

public class Database extends SQLiteOpenHelper {
    Context context;

    public Database(Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        create table DBSudoku (
            _id integer primary key autoincrement,
            deEasy text,
            deMedium text,
            deHard text,
            daEasy text,
            daMedium text,
            daHard text,
            tam text
        )
        */
        String sql="create table DBSudoku ( " +
                "_id integer primary key autoincrement, " +
                "deEasy text, " +
                "deMedium text, " +
                "deHard text, " +
                "daEasy text, " +
                "daMedium text, " +
                "daHard text, " +
                "tam text " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.rawQuery("drop table if exists database",null);
        onCreate(db);
    }

    public void taoDBSudoku(String deEasy,String deMedium, String deHard, String daEasy, String daMedium, String daHard)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("deEasy",deEasy);                  //gan tat ca gia tri truyen vao
        values.put("deMedium", deMedium);
        values.put("deHard", deHard);
        values.put("daEasy", daEasy);
        values.put("daMedium", daMedium);
        values.put("daHard", daHard);


        db.insert("DBSudoku", null, values);    //truyen tat ca gia tri vao bang
    }

    public Cursor layDBSudoku()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from DBSudoku",null);        // dung con tro de tro den database va lay du lieu ra
        return c;
    }

    public int soluong()     // dem so dong co trong database
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from DBSudoku",null);
        return c.getCount();
    }

}
