package com.example.stackviewdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.StackView;

public class MainActivity extends Activity {

	StackView stackview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stackview=(StackView)findViewById(R.id.stackView1);
		ArrayList<StackItem> items=new ArrayList<StackItem>();
		
		items.add(new StackItem("xe 1",getResources().getDrawable(R.drawable.car01)));
		items.add(new StackItem("xe 2",getResources().getDrawable(R.drawable.car02)));
		items.add(new StackItem("xe 3",getResources().getDrawable(R.drawable.car03)));
		items.add(new StackItem("xe 4",getResources().getDrawable(R.drawable.car04)));
		items.add(new StackItem("xe 5",getResources().getDrawable(R.drawable.car05)));
		items.add(new StackItem("xe 6",getResources().getDrawable(R.drawable.car06)));
		
		StackAdapter adapter=new StackAdapter(this, R.layout.item, items);
		stackview.setAdapter(adapter);
		
		stackview.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "vi tri : " +arg2, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
