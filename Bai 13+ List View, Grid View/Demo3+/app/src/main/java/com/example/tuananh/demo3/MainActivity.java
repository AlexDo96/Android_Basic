package com.example.tuananh.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv=(GridView)findViewById(R.id.GridView);


        ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();

        HashMap<String,Object> h1=new HashMap<String,Object>();
        h1.put("ten", "Lamborghini");
        h1.put("hinh",R.drawable.car01);
        list.add(h1);

        HashMap<String,Object> h2=new HashMap<String,Object>();
        h2.put("ten","Mercedes");
        h2.put("hinh",R.drawable.car02);
        list.add(h2);

        HashMap<String,Object> h3=new HashMap<String,Object>();
        h3.put("ten","Audi");
        h3.put("hinh",R.drawable.car03);
        list.add(h3);

        HashMap<String,Object> h4=new HashMap<String,Object>();
        h4.put("ten","BMW");
        h4.put("hinh",R.drawable.car04);
        list.add(h4);

        HashMap<String,Object> h5=new HashMap<String,Object>();
        h5.put("ten","Toyota");
        h5.put("hinh",R.drawable.car05);
        list.add(h5);

        HashMap<String,Object> h6=new HashMap<String,Object>();
        h6.put("ten","Nissan");
        h6.put("hinh",R.drawable.car06);
        list.add(h6);

        SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,
                list,
                R.layout.list_item,
                new String[]{"ten","hinh"},
                new int[]{R.id.textView,R.id.imageView});

        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Ban chon hinh thu "+ position+ " logo" ,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
