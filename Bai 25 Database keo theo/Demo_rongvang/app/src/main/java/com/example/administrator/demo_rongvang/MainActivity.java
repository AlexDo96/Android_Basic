package com.example.administrator.demo_rongvang;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    quanlycauhoi db;
    TextView tv;
    int socau=4;
    int index=0;
    ArrayList<cauhoi>ds_cauhoi;
    RadioButton rdo_a,rdo_b,rdo_c,rdo_d;
    cauhoi cauhientai;
    Button bt;
    int caudung=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        rdo_a=(RadioButton)findViewById(R.id.radioButton);
        rdo_b=(RadioButton)findViewById(R.id.radioButton2);
        rdo_c=(RadioButton)findViewById(R.id.radioButton3);
        rdo_d=(RadioButton)findViewById(R.id.radioButton4);
        bt=(Button)findViewById(R.id.button);

        db=new quanlycauhoi(MainActivity.this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("loi", e.toString());
        }
        db.close();//dong lai de dong bo hoa,va dam bao copy xong moi truy xuat duoc
        db=new quanlycauhoi(MainActivity.this);


        ds_cauhoi=new ArrayList<cauhoi>();
        ds_cauhoi=db.layNcaungaunhien(socau);

        hienthi(index);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///xu ly phan tinh diem o day
                String cautraloi="";
                if(rdo_a.isChecked()==true)
                    cautraloi="a";
                else if(rdo_b.isChecked()==true)
                cautraloi="b";
                else if(rdo_c.isChecked()==true)
                cautraloi="c";
                else if(rdo_d.isChecked()==true)
                cautraloi="d";
                else
                cautraloi="bo qua";

                Toast.makeText(getApplicationContext(), "cau tra loi " + cautraloi, Toast.LENGTH_SHORT).show();
                if(cautraloi.equalsIgnoreCase(cauhientai.dapan))
                {
                    caudung=caudung+1;
                }

                index++;
                if(index<socau)
                    hienthi(index);
                else
                {
                    ///xong roi ne, kich activity moi de bao ket qua
                    Toast.makeText(getApplicationContext(), "cau dung " + caudung, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    public void hienthi(int vitri)
    {
        cauhientai=ds_cauhoi.get(vitri);
        tv.setText(cauhientai.cauhoi);
        rdo_a.setText(cauhientai.cau_a);
        rdo_b.setText(cauhientai.cau_b);
        rdo_c.setText(cauhientai.cau_c);
        rdo_d.setText(cauhientai.cau_d);
    }

}
