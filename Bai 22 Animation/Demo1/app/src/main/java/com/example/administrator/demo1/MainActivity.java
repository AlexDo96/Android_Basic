package com.example.administrator.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    TextView tv;
    Animation hoathinh;
    boolean hien=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        bt3=(Button)findViewById(R.id.button3);

        bt4=(Button)findViewById(R.id.button4);
        bt5=(Button)findViewById(R.id.button5);

        bt6=(Button)findViewById(R.id.button6);
        bt7=(Button)findViewById(R.id.button7);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoathinh=AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_demo);
                tv.startAnimation(hoathinh);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hien==true)
                    hoathinh= new AlphaAnimation(1.0f,0.0f);
                else
                    hoathinh=new AlphaAnimation(0.0f,1.0f);
                hien=!hien;
                hoathinh.setDuration(2000);
                hoathinh.setFillAfter(true);
                tv.startAnimation(hoathinh);
                hoathinh.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "chay xong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoathinh=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_demo);
                tv.startAnimation(hoathinh);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoathinh=AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_demo);
                tv.startAnimation(hoathinh);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoathinh=AnimationUtils.loadAnimation(MainActivity.this,R.anim.tran_demo);
                tv.startAnimation(hoathinh);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoathinh=AnimationUtils.loadAnimation(MainActivity.this,R.anim.set_demo);
                tv.startAnimation(hoathinh);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HaiActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.out_demo, R.anim.in_demo);

            }
        });

    }
}
