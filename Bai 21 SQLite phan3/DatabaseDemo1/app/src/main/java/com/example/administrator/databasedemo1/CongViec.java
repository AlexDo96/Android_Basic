package com.example.administrator.databasedemo1;

import java.io.Serializable;

/**
 * Created by Administrator on 10/19/2016.
 */
public class CongViec implements Serializable {

    public int _id;
    public String noidung;
    public String thoigian;

    public CongViec(String noidung, String thoigian)           //Contrustor 2 tham so phuc vu cho viec them nen ko can ID
    {
        this.noidung=noidung;
        this.thoigian=thoigian;
    }
    public CongViec(int _id, String noidung, String thoigian)    //Contrustor 3 tham so phuc vu cho viec xoa, sua nen can ID
    {
        this._id=_id;
        this.noidung=noidung;
        this.thoigian=thoigian;
    }
}
