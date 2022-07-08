package com.example.administrator.dialogdemo1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView tv;
    AlertDialog.Builder mydialog;
    int x=0;               // bien tam nay de luu vi tri cu~ khi check diaglog dang RadioButton
    String []muc={"xanh","do","tim","vang"};
    boolean []mang_check={true,false,true,true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);

        mydialog=new AlertDialog.Builder(MainActivity.this);
        mydialog.setTitle("tui la cai dialog");
        //mydialog.setMessage("thoat chuong trinh");//kieu list phai bo cau lenh nay
        mydialog.setIcon(R.mipmap.ic_launcher);

        //nut dau tien
        mydialog.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();//lenh dung thoat activity
            }
        });
        //nut thu 2
        mydialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //nut thu 3
        mydialog.setPositiveButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //dialog dang list,khong can co button
/*        mydialog.setItems(muc, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText(muc[which]);
            }
        });*/

        //dialog dang radiobutton,can it nhat 1 button, muon nho lan chon truoc thi bo no vao su kien click cua nut
/*        mydialog.setSingleChoiceItems(muc, x, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                tv.setText(muc[which]);
                x=which;
            }
        });*/

        //alertdialog dang checkbox(chon nhieu trong nhieu), can it nhat 1 nut
        mydialog.setMultiChoiceItems(muc, mang_check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                tv.setText("");
                for(int i=0;i<mang_check.length;i++)
                    tv.append(mang_check[i] + ","); //Phương thức append() được sử dụng để nối chuỗi tham số đã cho với chuỗi mới
            }
        });



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = mydialog.create();   // khoi tao doi tuong dialog
                dialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();//neu chan lenh nay khi nhan back se khong thoat chuong trinh
    }
}
