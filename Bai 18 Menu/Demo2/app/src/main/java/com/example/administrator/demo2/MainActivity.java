package com.example.administrator.demo2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);

        tv.setOnClickListener(this);

    }

    public void xuly(View v)
    {
        PopupMenu pop=new PopupMenu(MainActivity.this,tv);
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu_item,pop.getMenu());
        pop.show();
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.menu1)
                    Toast.makeText(MainActivity.this,"menu 1",Toast.LENGTH_LONG).show();
                if(item.getItemId()==R.id.menu2)
                    Toast.makeText(MainActivity.this,"menu 2",Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}
