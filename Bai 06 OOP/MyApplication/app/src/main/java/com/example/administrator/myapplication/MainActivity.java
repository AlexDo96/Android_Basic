package com.example.administrator.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.package3.DongVat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=new Button(MainActivity.this);
        Button bt1=(Button)findViewById(R.id.button);
/*        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        bt1.setOnClickListener(this);
        Button bt2=(Button)findViewById(R.id.button2);
        ImageView iv=new ImageView(MainActivity.this);
        bt2.setOnClickListener(this);
        iv.setOnClickListener(this);

        HinhChuNhat a=new HinhChuNhat();
        int x=a.tinh;//x=1
        HinhChuNhat b=new HinhChuNhat();
        x=a.tinh;//x=2
        x=b.tinh;//x=2
        x=HinhChuNhat.tinh;//x=2

        a.xuatTT();
        a.congcong=9;
        a.khongghi=9;
        a.baove=9;
        //a.riengtu=9;//khong duoc

        HinhHop h=new HinhHop();
        h.xuatTT();


        HinhChuNhat c=new HinhHop();
        c.xuatTT();

        Tinh t=new Tinh();
        t.abc();
        Tinh.abc();

        double f= Math.PI;

        DongVat conheo= new DongVat() {
            @Override
            public void an() {

            }

            @Override
            public void ngu() {

            }
        };

        CountDownTimer tt=new CountDownTimer(100,10) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2)
        {

        }
    }
}
