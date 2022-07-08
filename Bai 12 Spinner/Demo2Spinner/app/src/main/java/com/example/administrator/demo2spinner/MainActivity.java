package com.example.administrator.demo2spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    TextView tv1,tv2;
    String[] mang=new String[]{"cam","xoai","coc","oi","miaghim"};
    String[] mang2={"an","an ngu","ngu", "ngu som", "di choi","di hoc","di ngu"};
    Button bt;
    AutoCompleteTextView act;
    MultiAutoCompleteTextView mact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=(Spinner)findViewById(R.id.spinner);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        bt=(Button)findViewById(R.id.button);
        act=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        mact=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,mang);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        //adapter.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tv1.setText(mang[position]);
                tv1.setText(sp.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(sp.getSelectedItem().toString());
            }
        });

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,mang2);
        act.setThreshold(1);
        act.setAdapter(adapter2);

        mact.setThreshold(1);
        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mact.setAdapter(adapter2);
    }
}
