package com.example.administrator.demo1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 11/12/2016.
 */
public class HaiActivity extends AppCompatActivity{


    Button bt;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hai);
        bt=(Button)findViewById(R.id.button);

    }
}
