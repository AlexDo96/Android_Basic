package com.example.administrator.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HaiActivity.class);
                //startActivity(i);//goi ma khong nhan tra ve

                String ten=et1.getText().toString();
                int tuoi=Integer.parseInt(et2.getText().toString());

                i.putExtra("ten",ten);
                i.putExtra("tuoi",tuoi);

                HinhChuNhat a=new HinhChuNhat(5,3);
                i.putExtra("hcn",a);       // put kieu doi tuong


                startActivityForResult(i,999);   // chuyen Activity va muon lay du lieu ve
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==999 && resultCode==RESULT_OK)
        {
            String ten=data.getStringExtra("ten");
            int tuoi =data.getIntExtra("tuoi",-1);
            tv.setText("ten: " + ten + " tuoi: " + tuoi);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
