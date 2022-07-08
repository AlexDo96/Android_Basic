package com.example.administrator.demo1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        ContentResolver ctr=getContentResolver();
        Cursor c= ctr.query(Settings.System.CONTENT_URI, null, null, null, null);
        String from[]=new String[]{Settings.System.NAME,Settings.System.VALUE};
        int to[]=new int[]{R.id.textView,R.id.textView2};
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(MainActivity.this,R.layout.mot_o,c,from,to);
        lv.setAdapter(adapter);

    }
}
