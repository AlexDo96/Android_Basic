package com.android.belamtoan;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BelamtoanActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_soA, et_soB, et_kq;
	Button bt_baimoi, bt_kiemtra;
	TextView tv_tb;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et_soA=(EditText)findViewById(R.id.editText1);
        et_soB=(EditText)findViewById(R.id.editText2);
        et_kq=(EditText)findViewById(R.id.editText3);
        
        bt_baimoi=(Button)findViewById(R.id.button1);
        bt_kiemtra=(Button)findViewById(R.id.button2);
        tv_tb=(TextView)findViewById(R.id.textView5);
        et_soA.setInputType(0);
        et_soB.setInputType(0);
        et_kq.setInputType(0);
        
        bt_baimoi.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Random r=new Random();
				int min=0 , max=10;
				int so2=r.nextInt(max-min+1)+min;
				int so1=r.nextInt(max-min+1)+min;
				
				et_soA.setText(String.valueOf(so2));
				et_soB.setText(String.valueOf(so1));
				
			}
			
			
		});
        
        bt_kiemtra.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int a=Integer.parseInt(et_soA.getText().toString());
				int b=Integer.parseInt(et_soB.getText().toString());
				int kqmay=a+b;
				int kqbe=Integer.parseInt(et_kq.getText().toString());
				if(kqmay==kqbe)
					tv_tb.setText("be gioi qua");
				else
					tv_tb.setText("be sai roi ket qua la " + kqmay);
				
			}
		});
        
        
        
    }
}