package com.example.dialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	
	Button bt_ngay,bt_gio;
	Calendar lich= Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_ngay=(Button)findViewById(R.id.button1);
		bt_gio=(Button)findViewById(R.id.button2);
		
		bt_gio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				chongio();
			}
		});
		
		bt_ngay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				chonngay();
			}
		});
		
	}

	public void chongio() 
	{
		TimePickerDialog tpdialog=new TimePickerDialog
				(
				MainActivity.this, 
				new OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						
						if(hourOfDay>=12)
						{
							hourOfDay=hourOfDay-12;
							bt_gio.setText(hourOfDay+":"+minute+" "+"PM");
						}
						else
						{
							bt_gio.setText(hourOfDay+":"+minute+" "+"AM");
						}
					}
				}, 
				lich.get(Calendar.HOUR), 
				lich.get(Calendar.MINUTE), 
				false
				);
		tpdialog.show();
	}
	
	public void chonngay()
	{
		DatePickerDialog dpdialog=new DatePickerDialog
				(
				MainActivity.this, 
				new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						bt_ngay.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
					}
				}, 
				lich.get(Calendar.YEAR), 
				lich.get(Calendar.MONTH), 
				lich.get(Calendar.DAY_OF_MONTH)
				);
			dpdialog.show();
	}
	
}
