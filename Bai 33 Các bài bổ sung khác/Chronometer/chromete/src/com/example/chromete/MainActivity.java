package com.example.chromete;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends Activity {

	Chronometer ch;
	Button start, stop, reset;
	long tg_dung=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ch=(Chronometer)findViewById(R.id.chronometer1);
		start=(Button)findViewById(R.id.button1);
		stop=(Button)findViewById(R.id.button2);
		reset=(Button)findViewById(R.id.button3);
		
		ch.setFormat("thoi gian la %s");
			
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch.setBase(SystemClock.elapsedRealtime()+tg_dung);
				ch.start();
			}
		});
		
		stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tg_dung=ch.getBase()-SystemClock.elapsedRealtime();
				ch.stop();
			}
		});

		reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ch.setBase(SystemClock.elapsedRealtime());
				ch.stop();//khong co lenh nay se reset va chay tiep
				tg_dung=0;
			}
		});
	
		ch.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer chronometer) {
				// TODO Auto-generated method stub
				String x=chronometer.getText().toString();
				if(x.equals("thoi gian la 00:10"))
				{
					Toast.makeText(getApplicationContext(),
							"da dat dieu kien",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
