package com.android.textviewdemo1;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Textviewdemo1Activity extends Activity {
    /** Called when the activity is first created. */
	TextView tv1;
	TextView tv5;
	TextView tv6;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv5=(TextView)findViewById(R.id.textView5);
        tv6=(TextView)findViewById(R.id.textView6);
        
        
        tv6.setText(Html.fromHtml(getString(R.string.chuoihtml)));
        
        Typeface face=Typeface.createFromAsset(this.getAssets(),"Blazed.ttf");
        tv1.setTypeface(face);
        
        int[] mausac={Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA};
        int dem=0;    
        SpannableString text5=new SpannableString("Lập trình web JSP");
        text5.setSpan(new UnderlineSpan(), 14,17, 0);
        for(int i=0;i<text5.length();i++)
        {
        	text5.setSpan(new RelativeSizeSpan(0.5f+(0.1f*i)),i,i+1,0);
        	text5.setSpan(new ForegroundColorSpan(mausac[dem]),i, i+1,0);
        	dem++;
        	if(dem==mausac.length)
        		dem=0;
        		
        }
        tv5.setText(text5,BufferType.SPANNABLE);

    }
}