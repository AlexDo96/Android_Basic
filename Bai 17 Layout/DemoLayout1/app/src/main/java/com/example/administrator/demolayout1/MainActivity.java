package com.example.administrator.demolayout1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout fl;
    int manghinhbai[]={

                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck,


                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk,


                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk,


                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    String mangtenbai[]={

                    "ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
                    "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
                    "boi chuon","dam chuon","gia chuon",


                    "ach ro","hai ro","ba ro","bon ro","nam ro",
                    "sau ro","bay ro","tam ro","chin ro","muoi ro",
                    "boi ro","dam ro","gia ro",


                    "ach co","hai co","ba co","bon co","nam co",
                    "sau co","bay co","tam co","chin co","muoi co",
                    "boi co","dam co","gia co",


                    "ach bich","hai bich","ba bich","bon bich","nam bich",
                    "sau bich","bay bich","tam bich","chin bich","muoi bich",
                    "boi bich","dam bich","gia bich"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl=(FrameLayout)findViewById(R.id.fl);

        for(int i=1;i<=13;i++) {
            ImageView iv = new ImageView(MainActivity.this);
            iv.setImageResource(manghinhbai[i]);

            FrameLayout.LayoutParams param=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT /* Set chieu ngang */ ,FrameLayout.LayoutParams.WRAP_CONTENT /* Set chieu doc */);
            param.setMargins(10+i*20,20,0,0);   // Set khoảng cách trái, trên, phải, dưới

            iv.setLayoutParams(param);  //gán param sau khi đã set vào imageview

            iv.setTag(i);   // dung de nhung them kieu du lieu View vao su dung cho doi tuong FrameLayout

            fl.addView(iv);   // add Image View vào Frame Layout

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ImageView iv=(ImageView)v;

                    FrameLayout.LayoutParams l=(FrameLayout.LayoutParams) iv.getLayoutParams();  // Ép kiểu Image View về LayoutParam và về FrameLayout

                    if(l.topMargin==20)                    // dieu kien de click vao la bai no bat len
                        l.topMargin=l.topMargin-10;
                    else
                        l.topMargin=20;

                    iv.setLayoutParams(l);

                    Toast.makeText(MainActivity.this,iv.getTag().toString()+"",Toast.LENGTH_SHORT).show();
                  /*  Toast.makeText(MainActivity.this,""+mangtenbai(),Toast.LENGTH_SHORT).show();*/
                }
            });
        }
    }
}
