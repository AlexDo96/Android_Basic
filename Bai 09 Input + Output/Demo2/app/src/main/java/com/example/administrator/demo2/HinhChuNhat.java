package com.example.administrator.demo2;

import java.io.Serializable;

/**
 * Created by Administrator on 9/21/2016.
 */
public class HinhChuNhat implements Serializable{   // Serializable là tiến trình biến đổi trạng thái của đối tượng theo một định dạng có thể được lưu trữ hay dịch chuyển.
    int cd;
    int cr;
    public HinhChuNhat(int cd,int cr)
    {
        this.cd=cd;
        this.cr=cr;
    }
}
