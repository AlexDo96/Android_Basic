package com.example.administrator.storagedemo1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button doc,ghi;
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doc=(Button)findViewById(R.id.doc);
        ghi=(Button)findViewById(R.id.ghi);
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);

        ghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //internal storage data/data/tenpackage/file/
                    /*
                    FileOutputStream out=openFileOutput("dulieu.txt",MODE_PRIVATE);
                    */

                    //external storage mnt/sdcard
                    /*
                    File duongdan= Environment.getExternalStorageDirectory();      // Tao duong dan vao external storage
                    File taptin=new File(duongdan,"abc.txt");                      // Tao mot tap tin vao duong dan da xac dinh o tren
                    FileOutputStream out=new FileOutputStream(taptin);*/


                    //external storage (public directory) mnt/sdcard/Music
                    /*
                    File duongdan= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);  // Tao duong dan den Music trong external storage
                    File taptin=new File(duongdan,"xyz.txt");                                                // Tao tap tin vao duong dan tren
                    FileOutputStream out=new FileOutputStream(taptin);*/

                    //external storage (tao nhieu thu muc con)
                    /*
                    String duongdan=Environment.getExternalStorageDirectory().toString();  //tuong duong String duongdan="mnt/sdcard";
                    File thumuc=new File(duongdan+"/mot/hai/ba/bon/nam/");                 // Tao cac thu muc con
                    thumuc.mkdirs();                                                       // Phuong thuc de tao nhieu thu muc con
                    File taptin=new File(thumuc,"zzz.txt");                                // Tao tap tin o thu muc con
                    FileOutputStream out=new FileOutputStream(taptin);
                    */

                    //internal storage cache file data/data/tenpackage/cache
                    File duongdan=getApplicationContext().getCacheDir();
                    File taptin=new File(duongdan+"/yyy.txt");
                    FileOutputStream out=new FileOutputStream(taptin);

                    String chuoi=et.getText().toString();
                    out.write(chuoi.getBytes());
                    out.close();

                }catch(Exception e)
                {

                }
            }
        });


        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    //internal storage
                    //FileInputStream in=openFileInput("dulieu.txt");

                    //external storage
                    /*
                    File duongdan= Environment.getExternalStorageDirectory();
                    File taptin=new File(duongdan,"abc.txt");

                    FileInputStream in=new FileInputStream(taptin);*/

                    //external storage (public directory)
                    /*
                    File duongdan= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                    File taptin=new File(duongdan,"xyz.txt");

                    FileInputStream in=new FileInputStream(taptin);*/

                    //external storage (tao thu muc con)
                    /*
                    String duongdan=Environment.getExternalStorageDirectory().toString();  //tuong duong String duongdan="mnt/sdcard";
                    File thumuc=new File(duongdan+"/mot/hai/ba/bon/nam/");
                    File taptin=new File(thumuc,"zzz.txt");

                    FileInputStream in=new FileInputStream(taptin);*/

                    //internal storage (cache file)
                    File duongdan=getApplicationContext().getCacheDir();
                    File taptin=new File(duongdan+"/yyy.txt");

                    FileInputStream in=new FileInputStream(taptin);


                    byte[] buffer=new byte[in.available()];
                    in.read(buffer);
                    String chuoi=new String(buffer);
                    tv.setText(chuoi);
                    in.close();

                }catch(Exception e)
                {

                }

            }
        });


    }
}
