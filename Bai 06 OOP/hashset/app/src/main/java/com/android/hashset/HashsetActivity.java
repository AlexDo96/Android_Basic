package com.android.hashset;

import java.util.HashSet;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HashsetActivity extends Activity {
    /** Called when the activity is first created. */
	
	EditText et_nhap;
	Button bt_th;
	TextView tv_tb;
	String mang[];
	HashSet<String> hs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et_nhap=(EditText)findViewById(R.id.editText1);
        bt_th=(Button)findViewById(R.id.button1);
        tv_tb=(TextView)findViewById(R.id.textView2);

        mang=new String[7];
        hs=new HashSet<String>(7);
        
        bt_th.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View arg0) {

				hs.clear();				
				mang=et_nhap.getText().toString().split(" ");
				
				for(int i=0;i<mang.length;i++)
					hs.add(mang[i].toString());
				
				String chuoi="";
				
				Iterator ite; //Iterator cho bạn khả năng để tuần hoàn qua một tập hợp, kiếm được và gỡ bỏ các phần tử.
				ite=hs.iterator(); //Sử dụng đối tượng Iterator, bạn có thể truy cập mỗi phần tử trong Collection, từng phần tử một tại một thời điểm.
				while(ite.hasNext())
				{
					chuoi+=ite.next().toString() + " ";
				}
			
				tv_tb.setText(chuoi);
			}
		});      
    }
}