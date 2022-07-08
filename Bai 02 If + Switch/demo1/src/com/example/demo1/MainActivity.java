package com.example.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText et1,et2;
	Button bt;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		bt=(Button)findViewById(R.id.button1);
		tv=(TextView)findViewById(R.id.textView3);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int x=Integer.parseInt(et1.getText().toString());
				int y=Integer.parseInt(et2.getText().toString());
				int z=x+y;
				tv.setText(getResources().getString(R.string.sum) + z);
			}
		});
	}
}
