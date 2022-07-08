package com.example.administrator.progressdialogdemo1;

import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt,bt2;
    TextView tv;
    ProgressDialog mydialog;
    ProgressBar pb;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.textView);
        pb=(ProgressBar)findViewById(R.id.progressBar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kieu tron
                //mydialog=ProgressDialog.show(MainActivity.this,"cho chut","cu tu tu chao cung nhu");

                //kieu dai
                mydialog = new ProgressDialog(MainActivity.this);
                mydialog.setMax(100);                            // cho chay den 100
                mydialog.setMessage("Its loading....");
                mydialog.setTitle("ProgressDialog bar example");
                mydialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mydialog.show();
                mydialog.setCancelable(true);
                CountDownTimer timer=new CountDownTimer(10000,1000) {   // tong thoi gian chay la 10s
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mydialog.incrementProgressBy(10);   // tang 10
                    }

                    @Override
                    public void onFinish() {
                        mydialog.dismiss();
                    }
                };
                timer.start();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer timer=new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        x+=10;
                        pb.setProgress(x);

                        tv.setText(x+"%");
                    }

                    @Override
                    public void onFinish() {
                        x+=10;
                        pb.setProgress(x);
                        tv.setText(x+"%" + " ket thuc");
                    }
                }.start();
            }
        });
    }
}
