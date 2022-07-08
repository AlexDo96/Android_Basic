package com.example.stackviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StackAdapter extends ArrayAdapter<StackItem>{
	
	 private ArrayList<StackItem> items;
	 private Context context;
	 
	public StackAdapter(Context context, int resource, ArrayList<StackItem> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.items=objects;
		this.context=context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null)
		{
			LayoutInflater inf=
					(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inf.inflate(R.layout.item, null);
		}
		
		StackItem stackitem=items.get(position);
		
		if(stackitem!=null)
		{
			TextView tv=(TextView)convertView.findViewById(R.id.textView1);
			ImageView iv=(ImageView)convertView.findViewById(R.id.imageView1);
			if(tv!=null)
			{
				tv.setText(stackitem.itemText);
				iv.setImageDrawable(stackitem.itemPhoto);
			}
		}
		
		return convertView;
	}
}
