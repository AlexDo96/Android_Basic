package com.example.administrator.demo2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/3/2016.
 */
public class MyAdapter extends BaseAdapter{
    ArrayList<Integer> list;
    Context context;
    MyAdapter(Context context,ArrayList<Integer> list)
    {
        this.list=list;
        this.context=context;
    }
    @Override
    public int getCount() {
        return list.size();
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
        ImageView iv=new ImageView(context);
        iv.setImageResource(list.get(position));
        iv.setLayoutParams(new GridView.LayoutParams(200,150));
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setPadding(1,1,1,1);
        return iv;
    }
}
