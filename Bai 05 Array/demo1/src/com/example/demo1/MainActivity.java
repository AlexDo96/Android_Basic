package com.example.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	ImageView iv;
	int manghinhbai[]={
			
			R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
			R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
			R.drawable.cj,R.drawable.cq,R.drawable.ck,
			
			
			R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
			R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
			R.drawable.dj,R.drawable.dq,R.drawable.dk,
			
			
			R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
			R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
			R.drawable.hj,R.drawable.hq,R.drawable.hk,
			
			
			R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
			R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
			R.drawable.sj,R.drawable.sq,R.drawable.sk
	};
	String mangtenbai[]={

			"ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
			"sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
			"boi chuon","dam chuon","gia chuon",
			
			
			"ach ro","hai ro","ba ro","bon ro","nam ro",
			"sau ro","bay ro","tam ro","chin ro","muoi ro",
			"boi ro","dam ro","gia ro",
			
			
			"ach co","hai co","ba co","bon co","nam co",
			"sau co","bay co","tam co","chin co","muoi co",
			"boi co","dam co","gia co",
			
			
			"ach bich","hai bich","ba bich","bon bich","nam bich",
			"sau bich","bay bich","tam bich","chin bich","muoi bich",
			"boi bich","dam bich","gia bich"	
	};

	TextView tv;
	Button bt;
	LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView)findViewById(R.id.imageView1);
		bt=(Button)findViewById(R.id.button1);
		tv=(TextView)findViewById(R.id.textView1);
		ll=(LinearLayout)findViewById(R.id.LinearLayout1);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int min=0,max=51;
				int r=min+ (int)(Math.random()*(max-min+1));
				iv.setImageResource(manghinhbai[r]);
				tv.setText(mangtenbai[r]+"button");
			}
		});
		
		ll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int min=0,max=51;
				int r=min+ (int)(Math.random()*(max-min+1));
				iv.setImageResource(manghinhbai[r]);
				tv.setText(mangtenbai[r]);
			}
		});
		
		
		CountDownTimer timer=new CountDownTimer(10000000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				int min=0,max=51;
				int r=min+ (int)(Math.random()*(max-min+1));
				iv.setImageResource(manghinhbai[r]);
				tv.setText(mangtenbai[r]);
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				
			}
		};
		timer.start();
	}
}
