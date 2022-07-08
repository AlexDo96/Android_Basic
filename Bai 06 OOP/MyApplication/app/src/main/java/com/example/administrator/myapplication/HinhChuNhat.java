package com.example.administrator.myapplication;

/**
 * Created by Administrator on 9/14/2016.
 */
public class HinhChuNhat {
    int cd;
    int cr;
    public int congcong;
    protected int baove;
    int khongghi;
    private int riengtu;
    public static int tinh=0;
    public HinhChuNhat()
    {
        cd=1;
        cr=1;
        congcong=5;
        baove=5;
        khongghi=9;
        riengtu=9;
        tinh++;
    }
    public HinhChuNhat(int x)
    {
        cd=x;
        cr=x;
        tinh++;
    }
    public HinhChuNhat(int cd,int cr)
    {
        this.cd=cd;
        this.cr=cr;
        tinh++;
    }
    public int tinhDienTich()
    {
        return cd*cr;
    }
    public int tinhChuVi()
    {
        return (cd+cr)*2;
    }
    public String xuatTT()
    {
        return "cd: "+ cd + " cr: "+cr+ "dt: "+ tinhDienTich()+ " cv: "+tinhChuVi();
    }
}
