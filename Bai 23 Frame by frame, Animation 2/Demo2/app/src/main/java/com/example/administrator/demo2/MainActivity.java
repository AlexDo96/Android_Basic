package com.example.administrator.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView tv;
    ImageView iv;
    Animation hh;
    float dau=0.0f, cuoi;
    int [] mang={-1,350,250,500,100,300,
                    800,500,700,-1,200,500,
                    900,300,250,900,200,400,
            550,200,500,-1,600,200
    };
    int dolech, phan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        iv=(ImageView)findViewById(R.id.imageView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min=400, max=700;
                cuoi=dau+(min + (int)(Math.random()*(max-min+1)));
                hh=new RotateAnimation(dau,cuoi,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                hh.setDuration(3000);
                hh.setFillAfter(true);
                iv.startAnimation(hh);
                dolech= (int)cuoi%360;
                phan=dolech/15;
                dau=dolech;
                hh.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tv.setText("dau:" + dau + " cuoi:" + cuoi + " dolech:" + dolech + " phan:" + phan + " giatri:" + mang[phan]);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}
