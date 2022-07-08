package com.android.hinhtron;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HinhtronActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_bk;
	Button bt_th;
	TextView tv_kq;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et_bk=(EditText)findViewById(R.id.editText1);
        bt_th=(Button)findViewById(R.id.button1);
        tv_kq=(TextView)findViewById(R.id.textView2);
        
        bt_th.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
					
			double bankinh=Double.parseDouble(et_bk.getText().toString());
			double dientich=3.14 * bankinh * bankinh;
			double chuvi= 2 * 3.14 * bankinh;
			tv_kq.setText("ban kinh "+ dientich + " chu vi "+ chuvi);
			
			}
		});
        
    }
}