package com.example.administrator.databasedemo1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/19/2016.
 */
public class MyAdapter extends BaseAdapter{

    Context context;
    ArrayList<CongViec> ds;

    public MyAdapter(Context context,ArrayList<CongViec> ds)
    {
        this.context=context;
        this.ds=ds;
    }

    @Override
    public int getCount() {
        return ds.size();
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
        View_Mot_O mot_o;
        LayoutInflater inf=((Activity)context).getLayoutInflater();     // Ép về context trước rồi lại ép về Activity cho nó hiểu được getLayoutInflater

        if(convertView==null)
        {
            mot_o=new View_Mot_O();
            convertView=inf.inflate(R.layout.list_view_item,null);    // truyền định dạng cho một ô trên ListView từ file xml

            mot_o.tv_id=(TextView)convertView.findViewById(R.id.textView);
            mot_o.tv_noidung=(TextView)convertView.findViewById(R.id.textView2);
            mot_o.tv_thoigian=(TextView)convertView.findViewById(R.id.textView3);
            convertView.setTag(mot_o);             //setTag để dành các đối tượng đã được định dạng phục vụ cho việc truy xuất sau này
        }
        else
        {
            mot_o=(View_Mot_O)convertView.getTag();
        }

        mot_o.tv_id.setText(ds.get(position)._id+"");               //lấy thông tin cho textview id của một ô
        mot_o.tv_noidung.setText(ds.get(position).noidung);         //lấy thông tin cho textview noidung của một ô
        mot_o.tv_thoigian.setText(ds.get(position).thoigian);       //lấy thông tin cho textview thoigian của một ô

        return convertView;
    }

    class View_Mot_O    // Thể hiện các thông tin cần có của một ô trong ListView
    {
        TextView tv_id;
        TextView tv_noidung;
        TextView tv_thoigian;

    }
}
