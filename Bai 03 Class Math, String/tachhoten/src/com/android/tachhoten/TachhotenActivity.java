package com.android.tachhoten;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TachhotenActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_hoten;
	Button bt_th;
	TextView tv_ho , tv_ten;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et_hoten=(EditText)findViewById(R.id.editText1);
        bt_th=(Button)findViewById(R.id.button1);
        tv_ho=(TextView)findViewById(R.id.textView2);
        tv_ten=(TextView)findViewById(R.id.textView3);
        
        bt_th.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String hoten=et_hoten.getText().toString();
				//vi tri cua khoang trang cuoi cung
				int khoangtrangcuoi=hoten.lastIndexOf(" ");
				
				//cat tu dau den khoangtrangcuoi
				String ho=hoten.substring(0,khoangtrangcuoi);
				
				//cat tu khoangtrangcuoi den cuoi chuoi
				String ten=hoten.substring(khoangtrangcuoi, hoten.length());
				
				tv_ho.setText("Họ : " + ho);
				tv_ten.setText("Ten : "+ ten);
				
				
			}
		});
        
    }
}