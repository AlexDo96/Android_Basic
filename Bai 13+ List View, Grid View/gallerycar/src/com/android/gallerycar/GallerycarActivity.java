package com.android.gallerycar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GallerycarActivity extends Activity {
    /** Called when the activity is first created. */
	
	Gallery gallery;
	ImageView imageview;
	private int[] ds_hinh={
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
        gallery=(Gallery)findViewById(R.id.gallery1);
        imageview=(ImageView)findViewById(R.id.imageView1);
        
        gallery.setAdapter(new myadapter(this));
        gallery.setSpacing(1);
        
        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				imageview.setImageResource(ds_hinh[arg2]);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }

    class myadapter extends BaseAdapter
    {
    	Context context;    	
    	//ham tao
    	public myadapter(Context c)
    	{
    		this.context=c;
    	}
    	
    	public int getCount() {
    		return ds_hinh.length;
    	}

    	public Object getItem(int position) {
    		return ds_hinh[position];
    	}

    	public long getItemId(int position) {
    		return position;
    	}
    	
    	
    	public View getView(int position, View convertView, ViewGroup parent) {

    		ImageView imageview=new ImageView(this.context);
    		imageview.setImageResource(ds_hinh[position]);
    		imageview.setScaleType(ImageView.ScaleType.FIT_END);
    		imageview.setLayoutParams(new Gallery.LayoutParams(200,200));
    		
    		return imageview;
    	}
    	
    }


}
