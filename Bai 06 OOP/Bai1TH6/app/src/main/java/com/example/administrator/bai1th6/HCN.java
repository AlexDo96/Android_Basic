package com.example.administrator.bai1th6;

/**
 * Created by Administrator on 9/12/2016.
 */
public class HCN {
    int cd;
    int cr;

    HCN(int cd, int cr)
    {
        this.cd=cd;
        this.cr=cr;
    }
    int CV()
    {
        return (cd+cr)*2;
    }

    int DT()
    {
        return cd*cr;
    }

    String KetquaCVDT ()
    {
        String x= "Chu vi =" + CV() + " " + "Dien tich =" + DT();
        return x;
    }
}
