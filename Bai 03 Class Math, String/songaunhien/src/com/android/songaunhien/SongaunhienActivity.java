package com.android.songaunhien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//cong thuc ngau nhien tu min->max
//   min +(int)(  Math.random()*( (max-min)+1 )  )


public class SongaunhienActivity extends Activity {
    /** Called when the activity is first created. */
	
	Button bt_th;
	TextView tv_kq;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bt_th=(Button)findViewById(R.id.button1);
        tv_kq=(TextView)findViewById(R.id.textView2);
        
        bt_th.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int x=(int)(Math.random()*101);
		        tv_kq.setText("ket qua: " + String.valueOf(x));
			}
		});
        
        
    }
}