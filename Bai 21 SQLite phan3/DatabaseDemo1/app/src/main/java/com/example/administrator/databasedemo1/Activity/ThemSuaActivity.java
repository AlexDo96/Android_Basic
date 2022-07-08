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
    Button bt_them_sua,bt_cancel;
    CongViec c;
    String co;      // Tạo biến cờ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua);

        tv_id=(TextView)findViewById(R.id.textView4);      // Hiển thị ID khi sửa thông tin
        et_noidung=(EditText)findViewById(R.id.editText);
        et_thoigian=(EditText)findViewById(R.id.editText2);
        bt_them_sua =(Button)findViewById(R.id.button);
        bt_cancel=(Button)findViewById(R.id.button2);

        co=getIntent().getExtras().get("co").toString();
        if(co.equals("sua"))              // Khi cờ bằng sua thì thể hiện các thông tin cần sửa lên Textview, Edittext
        {
            c=(CongViec)getIntent().getExtras().get("congviec");   // lấy data từ table congviec
            tv_id.setText(c._id+ "");
            et_noidung.setText(c.noidung);
            et_thoigian.setText(c.thoigian);
            bt_them_sua.setText("sua");
        }


        bt_them_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongViec cv;

                if(co.equals("them"))      // Xứ lý cho cờ thêm
                {
                    String noidung=et_noidung.getText().toString();
                    String thoigian=et_thoigian.getText().toString();
                    cv=new CongViec(noidung,thoigian);    //Lấy 2 thông tin của người dùng nhập vào EditText để truyền vào Contrustor 2 tham số
                }
                else              //Xử lý cho cờ sửa
                {
                    int id=Integer.parseInt(tv_id.getText().toString());
                    String noidung=et_noidung.getText().toString();
                    String thoigian=et_thoigian.getText().toString();
                    cv=new CongViec(id,noidung,thoigian);
                }

                Intent i=new Intent();            //Intent ko tham số vì trở về lại Acitivity chính
                i.putExtra("congviec",cv);   //đổ data vào bảng congviec
                setResult(RESULT_OK, i);
                finish();
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {   // Cancel ko làm gì cả, trả về Activity chính
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                setResult(RESULT_CANCELED,i);
                finish();
            }
        });
    }
}
