package com.example.administrator.demo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button bt;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.button);
        iv=(ImageView)findViewById(R.id.imageView);              // Hien thi hinh khi lay tu thu muc luu tru ve

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");                         // lay hinh ve

                Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);    // truy cap vao thu muc luu thu hinh
                Intent chosser=Intent.createChooser(pick, "chon");
                chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});

                startActivityForResult(chosser, 999);         // start Activity co lay du lieu ve

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)        // Tham so Intent data lay du lieu truyen ve
    {
        if (requestCode == 999 && resultCode == RESULT_OK) {

            if(data.getExtras()!=null)
            {
                Bundle extras = data.getExtras();            // Lay du lieu data khi truyen ve truyen vao Bundle
                Bitmap imageBitmap = (Bitmap) extras.get("data");         // Cho du lieu ep thanh Bitmap
                iv.setImageBitmap(imageBitmap);
            }
            else{
                Uri uri=data.getData();
                iv.setImageURI(uri);
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
