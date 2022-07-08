package com.android.buttondemo2;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Buttondemo2Activity extends Activity {
    /** Called when the activity is first created. */
	
	TextView tv;
	Button bt_tang,bt_giam;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv=(TextView)findViewById(R.id.textView1);
        bt_tang=(Button)findViewById(R.id.button1);
        bt_giam=(Button)findViewById(R.id.button2);
        
        bt_tang.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float x=tv.getTextSize();
				tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, x+1);
				tv.setText(String.valueOf(x));
			}
		});
        
        bt_giam.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float x=tv.getTextSize();
				tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,x-1);
				tv.setText(String.valueOf(x));
			}
		});
        
    }
}