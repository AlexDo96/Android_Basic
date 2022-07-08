package com.example.administrator.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HaiActivity extends AppCompatActivity {

    TextView tv,tv1;
    Button bt;
    String ten;
    int tuoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hai);

        tv=(TextView)findViewById(R.id.textView2);
        tv1=(TextView)findViewById(R.id.textView3);
        bt=(Button)findViewById(R.id.button);

        ten=getIntent().getStringExtra("ten");
        tuoi=getIntent().getExtras().getInt("tuoi");
        HinhChuNhat c= (HinhChuNhat)getIntent().getExtras().getSerializable("hcn");

        tv.setText("ten: " + ten + " tuoi: "+ tuoi);
        tv1.setText("cd: "+ c.cd + "cr: " + c.cr);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten= "cu "+ ten;
                tuoi++;
                Intent i=new Intent();         //intent khong doi so, tu dong tra ve cho thang goi no
                i.putExtra("ten",ten);
                i.putExtra("tuoi",tuoi);
                setResult(RESULT_OK,i);        //tra du lieu ve
                finish();                      //du lieu da tra ve nhung khong dong activity, dung lenh nay de dong activity
            }
        });

    }
}
