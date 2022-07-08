package com.example.administrator.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);

        try {
            InputStream in=getAssets().open("abc.txt");
            byte[] buffer=new byte[in.available()];
            in.read(buffer);
            String chuoi=new String(buffer);
            tv.setText(chuoi);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
