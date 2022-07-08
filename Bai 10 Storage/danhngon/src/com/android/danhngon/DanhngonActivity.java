package com.android.danhngon;

import java.io.InputStream;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DanhngonActivity extends Activity {
    /** Called when the activity is first created. */
	TextView tv,x;
	int sizemangchuoi=0;
	String[] mangchuoi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv=(TextView)findViewById(R.id.textView1);
        x=(TextView)findViewById(R.id.textView2);
        try{
        	
        	InputStream in=getAssets().open("danhngon.txt");
        	int size=in.available();
        	byte[] buffer=new byte[size];
        	in.read(buffer);
        	String chuoi=new String(buffer);
        	mangchuoi=chuoi.split("#");
        	sizemangchuoi=mangchuoi.length;
        }catch(Exception e)
        {
        	
        }   
    }
    
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Random rd=new Random();
		int vt=rd.nextInt(sizemangchuoi);//(b-a+1)+a0->sizemangchuoi
		tv.setText(mangchuoi[vt].toString());
		x.setText(vt+"/"+sizemangchuoi);
		return super.onTouchEvent(event);
	}

}