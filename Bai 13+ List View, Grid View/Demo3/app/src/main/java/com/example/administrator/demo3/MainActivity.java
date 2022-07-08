package com.example.administrator.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();

        HashMap<String,Object> h1=new HashMap<String,Object>();
        h1.put("ten", "nguyen van teo");
        h1.put("tuoi", "18");
        h1.put("hinh",R.drawable.car01);
        list.add(h1);

        HashMap<String,Object> h2=new HashMap<String,Object>();
        h2.put("ten","nguyen thi ti");
        h2.put("tuoi","17");
        h2.put("hinh",R.drawable.car02);
        list.add(h2);

        HashMap<String,Object> h3=new HashMap<String,Object>();
        h3.put("ten","nguyen van 12");
        h3.put("tuoi","21");
        h3.put("hinh",R.drawable.car03);
        list.add(h3);


        SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,
                list,
                R.layout.list_item,
                new String[]{"ten","tuoi","hinh"},
                new int[]{R.id.textView,R.id.textView2,R.id.imageView});

        lv.setAdapter(adapter);
    }
}
