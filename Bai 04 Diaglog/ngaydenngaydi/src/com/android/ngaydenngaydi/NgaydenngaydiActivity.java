package com.android.ngaydenngaydi;


import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NgaydenngaydiActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_ngayden, et_ngaydi;
	Button bt_th;
	TextView tv_ngayden,tv_ngaydi, tv_songay;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et_ngayden=(EditText)findViewById(R.id.editText1);
        et_ngaydi=(EditText)findViewById(R.id.editText2);
        bt_th=(Button)findViewById(R.id.button1);
        tv_ngayden=(TextView)findViewById(R.id.textView3);
        tv_ngaydi=(TextView)findViewById(R.id.textView4);
        tv_songay=(TextView)findViewById(R.id.textView5);
        
        et_ngayden.setInputType(0);
        et_ngaydi.setInputType(0);
        
        bt_th.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				SimpleDateFormat date_format=new SimpleDateFormat();
				date_format.applyPattern("d/M/y");
				date_format.setLenient(true);
				try
				{
					Date ng_den=date_format.parse(et_ngayden.getText().toString());
					Date ng_di=date_format.parse(et_ngaydi.getText().toString());
					
					String kq_den="ngay den: "+ ng_den.getDate();
					kq_den+=" thang "+(ng_den.getMonth()+1);
					kq_den+=" nam "+ (ng_den.getYear()+1900);					
					
					String kq_di="ngay di: " + ng_di.getDate();
					kq_di+= " thang " +(ng_di.getMonth()+1);
					kq_di+= " nam "+ (ng_di.getYear()+1900);

					long so_ngay=(ng_den.getTime()-ng_di.getTime())/24/60/60/1000;
					
					tv_ngayden.setText(kq_den);
					tv_ngaydi.setText(kq_di);
					tv_songay.setText("so ngay: "+String.valueOf(so_ngay));

				}catch(Exception e)
				{
					tv_ngayden.setText("khong thuc hien duoc");
				}
				
			}
		});
        
        
        
    }
}