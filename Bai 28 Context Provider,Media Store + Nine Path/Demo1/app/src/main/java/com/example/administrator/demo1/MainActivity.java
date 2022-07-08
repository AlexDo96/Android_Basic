package com.example.administrator.demo1;

import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.InputSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button bt;
    TextView tv;
    int index=0;
    int soluong=0;
    Button bt2;
    ArrayList<String> mang=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView);
        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.textView);

        ContentResolver ctr=getContentResolver();
        Cursor c=ctr.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, null, null, null);
        soluong=c.getCount();
        if(c.moveToFirst())
        {
            do{
                int indexcot=c.getColumnIndex(MediaStore.Images.Thumbnails.DATA);
                String src=c.getString(indexcot);
                mang.add(src);
            }while(c.moveToNext());
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,soluong+"",Toast.LENGTH_SHORT).show();
                iv.setImageURI(Uri.parse(mang.get(index)));
                tv.setText(mang.get(index));
                index++;
                if(index==soluong)
                    index=0;
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String src=mang.get(index);
                try {
                    InputStream is=new FileInputStream(src);
                    Bitmap bitmap=BitmapFactory.decodeStream(is);
                    WallpaperManager wm=WallpaperManager.getInstance(MainActivity.this);
                    wm.setBitmap(bitmap);

                } catch (Exception e) {
                    Log.d("loi",e.toString());
                }
            }
        });
    }
}
