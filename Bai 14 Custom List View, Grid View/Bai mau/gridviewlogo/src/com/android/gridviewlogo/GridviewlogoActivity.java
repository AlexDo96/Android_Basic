package com.android.gridviewlogo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridviewlogoActivity extends Activity {
    /** Called when the activity is first created. */
	
	GridView gv;
	String[]ten={"android","apple","blogger",
				"chrome","dell","facebook",
				"firefox","twitter","ie",
				"microsoft","hp","xbox"};
	
	int[]hinh={R.drawable.android,R.drawable.apple,R.drawable.blogger
			  ,R.drawable.chrome,R.drawable.dell,R.drawable.facebook
			  ,R.drawable.firefox,R.drawable.twitter,R.drawable.ie
			  ,R.drawable.microsoft,R.drawable.hp,R.drawable.xbox};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gv=(GridView)findViewById(R.id.gridView1);
        gv.setAdapter(new myadapter(this));
        gv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(GridviewlogoActivity.this,
						"ban chọn hình thứ "+position+ " logo "+ ten[position],
						Toast.LENGTH_SHORT).show();
			}
		});
        
    }
/////////////class đại dien cho  1 ô //////    
    public static class View_Mot_O
    {
    	public ImageView imageview;
    	public TextView textview;
    }
 ///////ket thuc class View_Mot_O///////////
    
    public class myadapter extends BaseAdapter
    {
    	Context context;
    	public myadapter(Context c)
    	{
    		context=c;
    	}
    	
		public int getCount() {
			// TODO Auto-generated method stub
			return hinh.length;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return hinh[position];
		}

		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			View_Mot_O mot_o;
			LayoutInflater layoutinflater= ((Activity)context).getLayoutInflater();
			
			if(arg1==null)  
			{  
				mot_o = new View_Mot_O();  
				arg1 = layoutinflater.inflate(R.layout.gridview_mot_o, null);  
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
    	
    }
}