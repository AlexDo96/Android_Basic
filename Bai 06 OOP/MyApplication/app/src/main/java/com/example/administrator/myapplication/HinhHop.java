package com.example.administrator.myapplication;

/**
 * Created by Administrator on 9/14/2016.
 */
public class HinhHop extends HinhChuNhat {
    int cc;

    HinhHop()
    {
        super();
        cc = 1;
        congcong=9;
        baove=9;
        khongghi=9;
        //riengtu=5;//khong duoc
    }

    HinhHop(int x)
    {
        super(x);
        cc = x;
    }

    HinhHop(int cd, int cr, int cc)
    {
        super(cd,cr);
        this.cc=cc;
    }
    int tinhTheTich()
    {
        return super.tinhDienTich()*cc;
    }
    public String xuatTT()
    {
        return super.xuatTT() + "cc: "+cc + " tt: "+tinhTheTich();
    }
}
