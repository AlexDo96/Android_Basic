package com.example.administrator.bai1th6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nhapcd,nhapcr;
    Button tinh;
    TextView ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nhapcd=(EditText)findViewById(R.id.editText);
        nhapcr=(EditText)findViewById(R.id.editText2);
        tinh=(Button)findViewById(R.id.button);
        ketqua=(TextView)findViewById(R.id.textView3);

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cdai=Integer.parseInt(nhapcd.getText().toString());
                int crong=Integer.parseInt(nhapcr.getText().toString());
                HCN hcn=new HCN(cdai,crong);

                String thongtin= hcn.KetquaCVDT();
                ketqua.setText(thongtin);
            }
        });
    }
}
