package com.example.administrator.gridviewcustom1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<Logo> ds=new ArrayList<Logo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gridView);

        ds.add(new Logo("android",R.drawable.android));
        ds.add(new Logo("apple",R.drawable.apple));
        ds.add(new Logo("blogger",R.drawable.blogger));
        ds.add(new Logo("chrome",R.drawable.chrome));
        ds.add(new Logo("dell",R.drawable.dell));
        ds.add(new Logo("facebook",R.drawable.facebook));
        ds.add(new Logo("firefox",R.drawable.firefox));
        ds.add(new Logo("hp",R.drawable.hp));
        ds.add(new Logo("ie",R.drawable.ie));
        ds.add(new Logo("microsoft",R.drawable.microsoft));
        ds.add(new Logo("twitter",R.drawable.twitter));
        ds.add(new Logo("xbox",R.drawable.xbox));


        MyAdapter adapter=new MyAdapter();
        gv.setAdapter(adapter);
    }

    class View_Mot_O
    {
        TextView tv;
        ImageView iv;
    }

    class MyAdapter extends BaseAdapter{

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

            LayoutInflater inf=getLayoutInflater();
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
            mot_o.tv.setText(ds.get(position).ten);
            mot_o.iv.setImageResource(ds.get(position).logo);

            return convertView;
        }
    }
}
