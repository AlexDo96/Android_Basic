package com.example.administrator.demo4;

import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipelayout;
    ListView lv;
    ArrayList<String> al=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int tong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        swipelayout=(SwipeRefreshLayout)findViewById(R.id.swipe_container);
        swipelayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        for(int i=0;i<10;i++)
        {
            tong++;
            al.add(0,tong+"");
        }
        Toast.makeText(MainActivity.this,al.size()+"",Toast.LENGTH_SHORT).show();
        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);


        swipelayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tong++;
                        al.add(0,tong+"");
                        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,al);
                        lv.setAdapter(adapter);
                    }

                    @Override
                    public void onFinish() {

                        swipelayout.setRefreshing(false);
                    }
                }.start();
            }
        });

    }
}
