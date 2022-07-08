package com.example.administrator.listviewcustom1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 10/5/2016.
 */
public class MyAdapter extends BaseAdapter {

    String ten[];
    int hinh[];
    Context context;

    class View_Mot_O
    {
        TextView tv;
        ImageView iv;
    }
    MyAdapter(Context context, String ten[], int hinh[])
    {
        this.ten=ten;
        this.hinh=hinh;
        this.context=context;
    }
    @Override
    public int getCount() {
        return hinh.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View_Mot_O mot_o;

        LayoutInflater inf=((Activity)context).getLayoutInflater();
        if(convertView==null) {
            convertView = inf.inflate(R.layout.listview_item, null);
            mot_o = new View_Mot_O();
            mot_o.tv = (TextView) convertView.findViewById(R.id.textView1);
            mot_o.iv = (ImageView) convertView.findViewById(R.id.imageView1);
            convertView.setTag(mot_o);

        }else
        {
            mot_o=(View_Mot_O)convertView.getTag();
        }
        mot_o.tv.setText(ten[position]);
        mot_o.iv.setImageResource(hinh[position]);

        convertView.setBackgroundResource(R.drawable.nutxanhlacay);

        mot_o.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"hinh " +position ,Toast.LENGTH_SHORT).show();
                ((MainActivity)context).xuly();
            }
        });

        return convertView;
    }
}
