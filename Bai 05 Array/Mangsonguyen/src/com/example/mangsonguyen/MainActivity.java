package com.example.mangsonguyen;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText et1;
	Button taomoi,xuatxuoi,xuatnguoc,minmax,saptangdan,dao,tong3pt;
	TextView tv_kq;
	int mang[]=new int[10];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
		tv_kq=(TextView)findViewById(R.id.textView2);
		taomoi=(Button)findViewById(R.id.button1);
		xuatxuoi=(Button)findViewById(R.id.button2);
		xuatnguoc=(Button)findViewById(R.id.button3);
		minmax=(Button)findViewById(R.id.button4);
		saptangdan=(Button)findViewById(R.id.button5);
		dao=(Button)findViewById(R.id.button6);
		tong3pt=(Button)findViewById(R.id.button7);
		
		taomoi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Random rd=new Random();
				String chuoi="";
				for(int i=0;i<10;i++)
				{
					mang[i]=rd.nextInt(50-10+1)+10;
				}
				DocMangRaEditText();
			}
		});
	}
	public void DocMangRaEditText()
	{
		String chuoi="";
		for(int i=0;i<10;i++)
		chuoi += mang[i] + " ";
		et1.setText(chuoi);
	}
}

