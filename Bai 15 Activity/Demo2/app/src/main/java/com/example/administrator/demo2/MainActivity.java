package com.example.administrator.demo2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HaiActivity.class);
                startActivity(i);
                finish();//mot di khong tro lai
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:54353535"));
                startActivity(i);
            }
        });
    }
}
