package com.example.wheel1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button bt;
	TextView tv;
	ImageView iv;
	Animation hh;
	int x[]={-1,350,250,500,1000,300,
			800,500,700,-1,200,500,
			900,300,250,900,200,400,
			550,200,500,-1,600,200
	};
	float gocdau=0.0f;
	int goccuoi=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt=(Button)findViewById(R.id.button1);
		tv=(TextView)findViewById(R.id.textView1);
		iv=(ImageView)findViewById(R.id.imageView1);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				int Min=500,Max=900;
				goccuoi=Min+(int)(Math.random()*((Max-Min)+1));
				//goccuoi=25;
				
				hh=new RotateAnimation(gocdau, goccuoi, 
						Animation.RELATIVE_TO_SELF, 0.5f, 
						Animation.RELATIVE_TO_SELF, 0.5f); 
				hh.setDuration(5000);
				hh.setInterpolator(new AccelerateDecelerateInterpolator());
				hh.setFillAfter(true);
				iv.setAnimation(hh);
				tv.setText("");
				hh.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
							int phan=goccuoi%360/15;
							tv.setText("xong: goccuoi "+goccuoi+ "dolech"+goccuoi%360+"phan:"+phan+"giatri:"+x[phan]);
							gocdau=goccuoi%360;
						
					}
				});
				
				
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
