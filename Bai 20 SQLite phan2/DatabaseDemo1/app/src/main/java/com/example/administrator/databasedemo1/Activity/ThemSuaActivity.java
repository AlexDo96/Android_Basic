package com.example.administrator.databasedemo1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.databasedemo1.CongViec;
import com.example.administrator.databasedemo1.R;

public class ThemSuaActivity extends AppCompatActivity {

    TextView tv_id;
    EditText et_noidung,et_thoigian;
    Button bt_them,bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua);

        tv_id=(TextView)findViewById(R.id.textView);
        et_noidung=(EditText)findViewById(R.id.editText);
        et_thoigian=(EditText)findViewById(R.id.editText2);
        bt_them=(Button)findViewById(R.id.button);
        bt_cancel=(Button)findViewById(R.id.button2);

        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung=et_noidung.getText().toString();
                String thoigian=et_thoigian.getText().toString();
                CongViec cv=new CongViec(noidung,thoigian);    //Lấy 2 thông tin của người dùng nhập vào EditText để truyền vào Contrustor 2 tham số

                Intent i=new Intent();            //Intent ko tham số vì trở về lại Acitivity chính
                i.putExtra("congviec",cv);   //đổ data vào bảng congviec
                setResult(RESULT_OK,i);
                finish();
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                setResult(RESULT_CANCELED,i);
            }
        });
    }
}
