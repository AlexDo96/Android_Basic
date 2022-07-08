package com.example.administrator.databasedemo1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    QuanLyUser qlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textView);

        qlus=new QuanLyUser(MainActivity.this);

        if(qlus.soluong()<=0) {      //check so dong co trong database neu ko co gi thi tao data moi
            qlus.taoUser("teo", "53534535" );
            qlus.taoUser("ti", "53453534" );
            qlus.taoUser("tin", "543534534" );
        }

        Cursor c=qlus.layUser();      // tao con tro de lay giu lieu

        if(c.moveToFirst()==true) {    // điều kiện moveToFirst == true tức là database có dữ liệu
            do {
                int id = Integer.parseInt(c.getString(0));
                String hoten = c.getString(1);
                String sodienthoai = c.getString(2);
                tv.append(id + " " + hoten + " "+ sodienthoai + "\n");
            } while (c.moveToNext());
        }

        qlus.close();   //đóng database

    }
}
