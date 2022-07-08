package com.example.administrator.demo_rongvang;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 10/31/2016.
 */
public class quanlycauhoi extends SQLiteOpenHelper{
    private static String DB_PATH = "/data/data/com.example.administrator.demo_rongvang/databases/";
    private static String DB_NAME = "databasecauhoi.sqlite";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="tablecauhoi";
    private static final String KEY_ID="_id";
    private static final String KEY_CAUHOI="cauhoi";
    private static final String KEY_A="cau_a";
    private static final String KEY_B="cau_b";
    private static final String KEY_C="cau_c";
    private static final String KEY_D="cau_d";
    private static final String KEY_DA="dapan";


    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public quanlycauhoi(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void  openDataBase() throws SQLException
    {
        myDataBase=SQLiteDatabase.openDatabase(DB_PATH+DB_NAME,null,SQLiteDatabase.OPEN_READONLY);
    }


    @Override
    public synchronized void close() {
        if(myDataBase!=null)
            myDataBase.close();
        super.close();
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);
        }catch(Exception e)
        {

        }
        if(checkDB!=null)
            checkDB.close();
        return  checkDB!=null ? true : false;
    }

    private void copyDataBase() throws IOException {
        //mo db trong thu muc assets nhu mot input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        //duong dan den db se tao
        String outFileName = DB_PATH + DB_NAME;

        //mo db giong nhu mot output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //truyen du lieu tu inputfile sang outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0)
        {
            myOutput.write(buffer, 0, length);
        }

        //Dong luon
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase(); //kiem tra db
        if(dbExist){
            //khong lam gi ca, database da co roi
        }
        else{
            this.getReadableDatabase();
            try {
                copyDataBase(); //chep du lieu
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }

    }

    public Cursor laytatcacauhoi()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor contro=db.rawQuery("select * from tablecauhoi", null);
        return contro;
    }

    public ArrayList<cauhoi> layNcaungaunhien(int socau)
    {
        ArrayList<cauhoi> ds_cauhoi=new ArrayList<cauhoi>();
        String limit="0,"+socau;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor contro=db.query(TABLE_NAME,
                null,//cac cot can lay
                null,//menh de where
                null,//doi so menh de where
                null,//group by
                null,//having
                "random()",//order by
                limit //limit(0,socau)
                );
        if(contro.moveToFirst()) {
            do {
                cauhoi x = new cauhoi();
                x._id = Integer.parseInt(contro.getString(0));
                x.cauhoi = contro.getString(1);
                x.cau_a = contro.getString(2);
                x.cau_b = contro.getString(3);
                x.cau_c = contro.getString(4);
                x.cau_d = contro.getString(5);
                x.dapan = contro.getString(6);
                ds_cauhoi.add(x);
            } while (contro.moveToNext());
        }
        return ds_cauhoi;
    }


}
