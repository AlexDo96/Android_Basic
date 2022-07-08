package com.example.administrator.sharedemo1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button doc,ghi;
    CheckBox cb;
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doc=(Button)findViewById(R.id.doc);
        ghi=(Button)findViewById(R.id.ghi);
        cb=(CheckBox)findViewById(R.id.checkBox);
        et=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView);

        ghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences ghi=getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor=ghi.edit();

                editor.putString("ten",et.getText().toString());
                editor.putInt("tuoi", 18);
                editor.putBoolean("nam",cb.isChecked());

                editor.commit();
            }
        });

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences doc=getPreferences(MODE_PRIVATE);
                String ten=doc.getString("ten", "chua co ten ba oi");
                int tuoi=doc.getInt("tuoi", -1);
                boolean nam=doc.getBoolean("nam",true);

                tv.setText("ten:" + ten + " tuoi: "+ tuoi + " nam: "+nam);
            }
        });

    }
}
