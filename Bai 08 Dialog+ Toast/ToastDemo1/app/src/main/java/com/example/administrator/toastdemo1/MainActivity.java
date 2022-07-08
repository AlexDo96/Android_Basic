package com.example.administrator.toastdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=(Button)this.findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // Toast binh thuong
                Toast.makeText(MainActivity.this,"tui la cai toast",Toast.LENGTH_SHORT).show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // Toast do
                Toast t=new Toast(MainActivity.this);
                t.setDuration(Toast.LENGTH_SHORT);
                LayoutInflater inf=getLayoutInflater();
                View layout=inf.inflate(R.layout.layout_toast, null);
                ImageView iv=(ImageView)layout.findViewById(R.id.image);
                iv.setImageResource(R.mipmap.ic_launcher);
                TextView tv=(TextView)layout.findViewById(R.id.text);
                tv.setText("tui la cai toast do");
                t.setView(layout);
                t.setGravity(Gravity.TOP|Gravity.LEFT,100,100);
                t.show();
            }
        });
    }
}
