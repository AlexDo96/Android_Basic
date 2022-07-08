package com.example.administrator.demotoolbar1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);  //id toolbar o activity_main
        setSupportActionBar(toolbar);               //gan Toolbar thanh ActionBar
        toolbar.setNavigationIcon(R.drawable.ic_back);    //gan icon back
        toolbar.setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);     //gan su kien hỗ trợ hành động quay về
        getSupportActionBar().setDisplayShowHomeEnabled(true);     //gan su kien hỗ trợ hành động quay về

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {       // Tao Toolbar
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
