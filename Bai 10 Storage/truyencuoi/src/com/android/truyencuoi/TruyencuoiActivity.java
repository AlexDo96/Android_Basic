package com.android.truyencuoi;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TruyencuoiActivity extends Activity {
    /** Called when the activity is first created. */
	Button dau,cuoi,truoc,sau;
	TextView tieude,noidung;
	int vt=0;
	String[] truyen;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dau=(Button)findViewById(R.id.button1);
        truoc=(Button)findViewById(R.id.button2);
        sau=(Button)findViewById(R.id.button3);
        cuoi=(Button)findViewById(R.id.button4);
        tieude=(TextView)findViewById(R.id.textView1);
        noidung=(TextView)findViewById(R.id.textView2);
        
        try {
			InputStream in=getAssets().open("truyencuoi.txt");
			byte[] buffer=new byte[in.available()];
			in.read(buffer);
			String chuoi=new String(buffer);
			truyen=chuoi.split("#");
			hienthi(vt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        dau.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				vt=0;
				hienthi(vt);
			}
		});
        
        cuoi.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				vt=truyen.length-1;
				hienthi(vt);
			}
		});
        
        truoc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(vt!=0)
					vt--;
				hienthi(vt);
			}
		});
        
        sau.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(vt!=truyen.length-1)
					vt++;
				hienthi(vt);
			}
		});
        
    }
	public void hienthi(int vitri)
	{
		String s_truyen=truyen[vitri].toString();
		String [] tach=s_truyen.split("\\*");
		if(vitri==0)
		{
			dau.setEnabled(false);
			truoc.setEnabled(false);
		}
		else
		{
			dau.setEnabled(true);
			truoc.setEnabled(true);
		}
		if(vitri==truyen.length-1)
		{
			sau.setEnabled(false);
			cuoi.setEnabled(false);
		}
		else
		{
			sau.setEnabled(true);
			cuoi.setEnabled(true);
		}
		tieude.setText(tach[0].toString());
		noidung.setText(tach[1].toString());
	}
	
	
}