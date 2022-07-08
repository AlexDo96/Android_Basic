package com.example.administrator.databasedemo1.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.databasedemo1.CongViec;
import com.example.administrator.databasedemo1.MyAdapter;
import com.example.administrator.databasedemo1.R;
import com.example.administrator.databasedemo1.quanlycongviec;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<CongViec> ds=new ArrayList<CongViec>();
    quanlycongviec qlcv;
    MyAdapter adapter;
    FloatingActionButton fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView);
        fa=(FloatingActionButton)findViewById(R.id.nutfloating);
        qlcv=new quanlycongviec(MainActivity.this);

        capnhatlistview();

        fa.setOnClickListener(new View.OnClickListener() {       //nút chuyển đến Themsua Activity
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ThemSuaActivity.class);
                startActivityForResult(i,999);
            }
        });

    }

    public void capnhatlistview()
    {
        ds=qlcv.layCongViec();
        adapter=new MyAdapter(MainActivity.this,ds);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    //tạo Option Menu
        MenuInflater inf=getMenuInflater();           //tạo giao diện cho Menu
        inf.inflate(R.menu.menu_option,menu);         //gán giao diện

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {              //set event khi click Menu
        if(item.getItemId()==R.id.them)
        {
            Intent i=new Intent(MainActivity.this,ThemSuaActivity.class);
            startActivityForResult(i,999);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {      // Bước lấy dữ liệu và truyền vào database khi đã nhận được dữ liệu truyền về từ Activity Them Sua
        if(requestCode==999 && resultCode==RESULT_OK)
        {
            CongViec cv=(CongViec)data.getSerializableExtra("congviec");      //Phải dùng getSerializableExtra vì data truyền về là một Object
            qlcv.themCongViec(cv);
            capnhatlistview();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
