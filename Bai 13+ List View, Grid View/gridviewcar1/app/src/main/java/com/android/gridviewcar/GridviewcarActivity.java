package com.android.gridviewcar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridviewcarActivity extends Activity {
    /** Called when the activity is first created. */
	GridView gv;
	int [] ds_hinh={
			R.drawable.car01,
			R.drawable.car02,
			R.drawable.car03,
			R.drawable.car04,
			R.drawable.car05,
			R.drawable.car06
			
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gv=(GridView)findViewById(R.id.gridView1);
        
        gv.setAdapter(new myadapter(this));
        
        gv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(GridviewcarActivity.this, 
						"ban chọn hình thứ "+(arg2+1),Toast.LENGTH_SHORT).show();
				
			}
		});     
    }

    class myadapter extends BaseAdapter
    {
    	private Context context;
    	public myadapter(Context c)
    	{
    		this.context=c;
    	}
    	
		public int getCount() {
			return ds_hinh.length;
		}

		public Object getItem(int arg0) {
			return null;
		}

		public long getItemId(int arg0) {
			return 0;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView imageview;
			imageview=new ImageView(context);
			imageview.setLayoutParams(new GridView.LayoutParams(200,150));
			imageview.setScaleType(ImageView.ScaleType.FIT_XY);
			imageview.setPadding(1,1,1,1);
			imageview.setImageResource(ds_hinh[arg0]);
			
			return imageview;
		}
    	
    }
}