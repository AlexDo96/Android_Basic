package com.example.administrator.demo1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv=(VideoView)findViewById(R.id.videoView);

        vv.setMediaController(new MediaController(MainActivity.this));
        Uri video= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.haivui1);
        vv.setVideoURI(video);
        vv.start();
    }
}
