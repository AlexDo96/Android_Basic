package com.example.administrator.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[]mang=new int[]{R.drawable.car01,
            R.drawable.car02,
            R.drawable.car03,
            R.drawable.car04,
            R.drawable.car05,
            R.drawable.car06};
    Gallery gl;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl=(Gallery)findViewById(R.id.gallery);
        iv=(ImageView)findViewById(R.id.imageView);

        MyAdapter adapter=new MyAdapter();
        gl.setAdapter(adapter);

        gl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(mang[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return mang.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv=new ImageView(MainActivity.this);
            iv.setImageResource(mang[position]);
            Gallery.LayoutParams params=new Gallery.LayoutParams(200,200);
           // Gallery.LayoutParams params=new Gallery.LayoutParams(Gallery.LayoutParams.MATCH_PARENT,Gallery.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(params);
            iv.setScaleType(ImageView.ScaleType.FIT_END);
            return iv;
        }
    }
}
