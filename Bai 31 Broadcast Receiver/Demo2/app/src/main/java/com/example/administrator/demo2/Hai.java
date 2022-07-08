package com.example.administrator.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by Administrator on 11/14/2016.
 */
public class Hai  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isEnabled = Settings.System.getInt(
                context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1;
        if(isEnabled==true) {
            Toast.makeText(context, "che do may bay bat", Toast.LENGTH_SHORT).show();
            // toggle airplane mode
            Settings.System.putInt(
                    context.getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0);
        }
        else{
            Toast.makeText(context, "che do may bay tat", Toast.LENGTH_SHORT).show();


            /*// Post an intent to reload
            Intent i = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            i.putExtra("state", !isEnabled);
            context.sendBroadcast(i);*/
        }

    }
}
