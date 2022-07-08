package com.example.administrator.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.editText);
        bt=(Button)findViewById(R.id.button);
        cb=(CheckBox)findViewById(R.id.checkBox);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().equals(""))
                    et.setError("chua nhap ba oi");
                /*
                if(cb.isChecked()==true)
                {
                    cb.setChecked(false);
                }*/
                cb.toggle();
            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                    Toast.makeText(MainActivity.this,"true",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"false",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
