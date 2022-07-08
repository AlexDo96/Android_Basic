package com.android.chuoihoathuong;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChuoihoathuongActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_nhap;
	Button bt_th;
	TextView tv_hoa,tv_thuong,tv_hoadau;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et_nhap=(EditText)findViewById(R.id.editText1);
        et_nhap.setInputType(0);
        bt_th=(Button)findViewById(R.id.button1);
        tv_hoa=(TextView)findViewById(R.id.textView2);
        tv_thuong=(TextView)findViewById(R.id.textView3);
        tv_hoadau=(TextView)findViewById(R.id.textView4);
        
        bt_th.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String chuoinhap=et_nhap.getText().toString();
				tv_hoa.setText(chuoinhap.toUpperCase());
				tv_thuong.setText(chuoinhap.toLowerCase());
				
				String chuoihoadau=chuoinhap.toLowerCase(); //tao 1 chuoi moi la chu thuong
				char[] mangkitu = chuoihoadau.toCharArray(); //tach chuỗi thành mảng các kí tự
				mangkitu[0] = Character.toUpperCase(mangkitu[0]);//hoa kí tự đầu tiên
				
				//duyêt nếu gặp kí tự  trắng thi hoa kí tự tiếp theo
				for(int i=1;i<mangkitu.length;i++)
					if(mangkitu[i]==' ')
					{
						mangkitu[i+1]=Character.toUpperCase(mangkitu[i+1]);
					}
				
				chuoihoadau = new String(mangkitu); 
					
				tv_hoadau.setText(chuoihoadau.toString());
				
				
			}
		});
        
    }
}