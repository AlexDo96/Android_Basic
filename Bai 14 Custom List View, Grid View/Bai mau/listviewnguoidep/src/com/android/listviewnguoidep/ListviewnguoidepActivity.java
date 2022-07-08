package com.android.listviewnguoidep;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListviewnguoidepActivity extends Activity {
    /** Called when the activity is first created. */
    ListView lv;
    
    String []ten={ "kim hee sun","kim nam joo",
					"kim so eun","kim tae hee",
					"kim chi","kimbap", 
					"kim hee sun","kim nam joo",
					"kim so eun","kim tae hee",
					"kim chi","kimbap"
    
    };

    int []hinh={ R.drawable.kimheesun,R.drawable.kimnamjoo,
	   	R.drawable.kimsoeun,R.drawable.kimtaehee,
	   	R.drawable.kimchi,R.drawable.kimbap, 
	   	
	   	R.drawable.kimheesun,R.drawable.kimnamjoo,
	   	R.drawable.kimsoeun,R.drawable.kimtaehee,
	   	R.drawable.kimchi,R.drawable.kimbap
    };
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv=(ListView)findViewById(R.id.listView1);
        
        
        lv.setAdapter(new myadapter(this,ten));     //cach 1
        //lv.setAdapter(new myadapter1(this));      //cach 2
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				TextView tv=(TextView)arg1.findViewById(R.id.textView1);
				Toast.makeText(getApplicationContext(), 
						"ban chon "+tv.getText().toString(),Toast.LENGTH_SHORT).show();
			}
        });
    
    }
	//cach 1
	
	class myadapter extends ArrayAdapter{
		Context context;
		

		public myadapter(Context context,String [] ten)
		{
			super(context,R.layout.listview_item,ten);
			this.context=context;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// dung layoutinflater lấy đọc cấu trúc và nội dung của từng hàng listview
			LayoutInflater inf=(LayoutInflater)
					context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowview=inf.inflate(R.layout.listview_item,parent, false);
			
			//ánh xạ từng hàng listview , cập nhật thông tin
			TextView textview=(TextView)rowview.findViewById(R.id.textView1);
			ImageView imageview=(ImageView)rowview.findViewById(R.id.imageView1);
			
			textview.setText(ten[position]);
			imageview.setImageResource(hinh[position]);
			
			return rowview;
		}
	
	}
	
	//cach 2
	/*
	public static class View_Mot_O
	{
		ImageView imageview;
		TextView textview;
	}
	class myadapter1 extends BaseAdapter{
		Context context;
		
		myadapter1(Context c)
		{
			context=c;
		}
		
		public int getCount() {
			// TODO Auto-generated method stub
			
			return hinh.length;
		}

		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return hinh[arg0];
		}

		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			View_Mot_O mot_o;
			LayoutInflater inf= ((Activity)context).getLayoutInflater();
			if(arg1==null)  
			{  
				mot_o = new View_Mot_O();  
				arg1 = inf.inflate(R.layout.listview_item, null);  
				mot_o.textview = (TextView) arg1.findViewById(R.id.textView1);  
				mot_o.imageview = (ImageView)arg1.findViewById(R.id.imageView1);  
				arg1.setTag(mot_o);  
			}  
			else
				mot_o=(View_Mot_O)arg1.getTag();
			
			
			
			mot_o.imageview.setImageResource(hinh[arg0]);
			mot_o.textview.setText(ten[arg0]);
			
			return arg1;
		}
		
	}*/
}