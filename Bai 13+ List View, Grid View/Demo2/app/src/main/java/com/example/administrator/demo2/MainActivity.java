package com.example.administrator.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<Integer> list=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gridView);

        list.add(R.drawable.car01);
        list.add(R.drawable.car02);
        list.add(R.drawable.car03);
        list.add(R.drawable.car04);
        list.add(R.drawable.car05);
        list.add(R.drawable.car06);

        MyAdapter adapter=new MyAdapter(MainActivity.this,list);
        gv.setAdapter(adapter);


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
