package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	EditText et1,et2;
	Button bt;
	TextView tv1,tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		bt=(Button)findViewById(R.id.button1);
		tv1=(TextView)findViewById(R.id.textView4);
		tv2=(TextView)findViewById(R.id.textView6);
		
		
	bt.setOnClickListener(new View.OnClickListener()
	{
		public void onClick(View v)
		{
		int cd=Integer.parseInt(et1.getText().toString());
		int cr=Integer.parseInt(et2.getText().toString());
		int cv=(cd+cr)*2;
		int dt=cd*cr;
		tv1.setText(cv+"");
		tv2.setText(dt+"");
		}
	});

	}
}
