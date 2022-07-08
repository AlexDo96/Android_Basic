package com.example.administrator.demo1;

import java.io.Serializable;

/**
 * Created by Administrator on 10/10/2016.
 */
public class HinhChuNhat implements Serializable     // Muon put kieu doi tuong thi dung implements Serializable de xâu xỏ
{
    int cd;
    int cr;
    HinhChuNhat(int cd,int cr)
    {
        this.cd=cd;
        this.cr=cr;
    }
}
