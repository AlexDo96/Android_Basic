package com.example.administrator.demo3;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tb=getTabHost();

        TabHost.TabSpec tabHappy=tb.newTabSpec("happy");
        tabHappy.setIndicator("Happy");
        Intent h=new Intent(this,Tab1Activity.class);
        tabHappy.setContent(h);
        tb.addTab(tabHappy);

        TabHost.TabSpec tabSad=tb.newTabSpec("sad");
        tabSad.setIndicator("Sad");
        Intent h2=new Intent(this,Tab2Activity.class);
        tabSad.setContent(h2);
        tb.addTab(tabSad);

    }
}
