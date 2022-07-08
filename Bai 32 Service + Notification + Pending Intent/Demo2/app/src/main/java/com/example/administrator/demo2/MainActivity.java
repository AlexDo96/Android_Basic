package com.example.administrator.demo2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt;
    NotificationManager notimanager;
    Notification.Builder notibui;
    Notification noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notimanager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                notibui=new Notification.Builder(getApplicationContext());
                notibui.setContentTitle("tieu de noti");
                notibui.setContentText("noi dung cua noti");
                notibui.setSmallIcon(R.mipmap.ic_launcher);
                notibui.setAutoCancel(true);

                //Intent i=new Intent(MainActivity.this,MainActivity.class);
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                PendingIntent pe=PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_ONE_SHOT);
                notibui.setContentIntent(pe);

                noti=notibui.getNotification();

                notimanager.notify(0,noti);
            }
        });
    }
}
