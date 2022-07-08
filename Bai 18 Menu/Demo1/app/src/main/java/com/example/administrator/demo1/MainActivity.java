package com.example.administrator.demo1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] mang=new String[]{"cam","xoai","coc","oi","miaghim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mang);  //gan gia tri mang vao adapter
        lv.setAdapter(adapter);

        registerForContextMenu(lv);   // đăng kí Listview đc áp ContextMenu vào
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {     // Menu ngu canh
        MenuInflater inf=getMenuInflater();    // dung MenuInflater de nap file menu resource dang xml vao
        inf.inflate(R.menu.menu_ngucanh, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();   //item.getMenuInfo() dung de lay thong tin item tren listview
        int index=info.position;        // xac dinh vi tri chon item tren listview

        if(item.getItemId()==R.id.can)
            Toast.makeText(MainActivity.this,"can "+mang[index],Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.cap)
            Toast.makeText(MainActivity.this,"cap " + mang[index],Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.nhai)
            Toast.makeText(MainActivity.this,"nhai "+mang[index],Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {            //Menu Action Bar
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu_option_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_search)
            Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.action_help)
            Toast.makeText(MainActivity.this,"help",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
