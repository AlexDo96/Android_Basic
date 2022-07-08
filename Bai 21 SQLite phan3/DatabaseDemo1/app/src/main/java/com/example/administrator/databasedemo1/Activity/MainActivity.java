package com.example.administrator.databasedemo1.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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

        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThemSuaActivity.class);
                i.putExtra("co","them");        // Gán cở bằng them để phân biệt so với event Sửa cũng chuyển qua ThemSuaActivity
                startActivityForResult(i, 999);
            }
        });

        registerForContextMenu(lv);   // Đăng kí ContextMenu cho ListView

    }

    void capnhatlistview()
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.them)
        {
            /* Intent i=new Intent(MainActivity.this,ThemSuaActivity.class);
            i.putExtra("co","them");
            startActivityForResult(i,999);*/
            taoDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu_context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo inf=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        int index=inf.position;        //Inflater position trả về vị trí thứ index trong Listview
        int id=ds.get(index)._id;      // Adpater lấy giá trị index đó để trả về giá trị vị trí id trong database -> Trả về giá trị id

        if(item.getItemId()==R.id.xoa)
        {
            qlcv.xoaCongViec(id);      //Xóa theo id
            capnhatlistview();
        }

        if(item.getItemId()==R.id.sua)
        {
            Intent i=new Intent(MainActivity.this,ThemSuaActivity.class);
            CongViec c=ds.get(index);
            i.putExtra("congviec",c);
            i.putExtra("co","sua");      // Gán cở bằng sửa để phân biệt so với event Thêm cũng chuyển qua ThemSuaActivity
            startActivityForResult(i, 333);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  // Chuyển sang Activity khác, thực thi các lệnh và lấy dữ liệu về
        if(requestCode==999 && resultCode==RESULT_OK)
        {
            CongViec c=(CongViec)data.getSerializableExtra("congviec");
            qlcv.themCongViec(c);
            capnhatlistview();
        }

        if(requestCode==333 && resultCode==RESULT_OK)
        {
            CongViec c=(CongViec)data.getSerializableExtra("congviec");
            qlcv.suaCongViec(c);
            capnhatlistview();
        }
        super.onActivityResult(requestCode, resultCode, data);   // Dữ liệu nhận về gồm requestCode, resultCode, data
    }

    public void taoDialog()      // Tạo dialog
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view=inflater.inflate(R.layout.layout_dialog, null);     //gán layout cho dialog và dùng final vì chỉ sử dụng ko dẫn xuất thêm, hạn chế, ngăn ngừa các lớp khác dẫn xuất từ nó.
        alertDialog.setView(view);


        alertDialog.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText et_n=(EditText)view.findViewById(R.id.d_noidung);
                EditText et_t=(EditText)view.findViewById(R.id.d_thoigian);

                String noidung=et_n.getText().toString();
                String thoigian=et_t.getText().toString();

                CongViec c=new CongViec(noidung,thoigian);
                qlcv.themCongViec(c);
                capnhatlistview();
            }
        });

        alertDialog.setNeutralButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();

    }
}
