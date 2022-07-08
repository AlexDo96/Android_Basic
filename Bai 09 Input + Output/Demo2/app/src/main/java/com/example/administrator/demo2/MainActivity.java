package com.example.administrator.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button clear;
    Button write;
    Button load,bt_doctutu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.editText);
        clear=(Button)findViewById(R.id.clear);
        write=(Button)findViewById(R.id.write);
        load=(Button)findViewById(R.id.load);
        bt_doctutu=(Button)findViewById(R.id.button);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //luu chuoi (kieu nhi phan)
/*                  FileOutputStream out=openFileOutput("abc.dat",MODE_PRIVATE);
                    String chuoi=et.getText().toString();
                    out.write(chuoi.getBytes());
                    out.close();*/

                    //luu kieu doi tuong
/*                  FileOutputStream out=openFileOutput("cde.dat",MODE_PRIVATE);
                    ObjectOutputStream oos=new ObjectOutputStream(out);
                    HinhChuNhat h=new HinhChuNhat(5,3);
                    oos.writeObject(h);
                    oos.close();
                    out.close();*/


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //doc chuoi (kieu nhi phan)
/*                  FileInputStream in=openFileInput("abc.dat");
                    byte[] buffer=new byte[in.available()];
                    in.read(buffer);
                    et.setText(new String(buffer));
                    in.close();*/


                    //doc doi tuong
/*                  FileInputStream in=openFileInput("cde.dat");
                    ObjectInputStream ois=new ObjectInputStream(in);
                    HinhChuNhat h=(HinhChuNhat)ois.readObject();
                    et.setText("cd:"+ h.cd + " cr: "+ h.cr);
                    ois.close();
                    in.close();*/



                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        bt_doctutu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("a.jpg");
                    FileOutputStream out=openFileOutput("b.jpg", MODE_PRIVATE);
                    byte[] buffer=new byte[1024];     //doc tung byte voi kich thuoc 1024 KB
                    int len=0;                        // tao 1 bien tam de do kich thuoc cua file

                    // Khong nen su dung phuong thuc size.available() vi chua biet duoc kich thuoc file
                    // Neu file qua lon ma su dung phuong thuc size.available() de gan vao Ram chay chuong trinh thi se co hien tuong doom Ram

                    while((len=in.read(buffer))>0)      //dieu kien doc tung byte va xuat ra khi da doc het du lieu cua file
                    {
                        out.write(buffer, 0, len);
                    }


                    in.close();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
