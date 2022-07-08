package com.example.administrator.demo3;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_sendapi,bt_sendintent,bt_readsms;
    ListView lv;
    ArrayList<String> ds=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_sendapi=(Button)findViewById(R.id.sendsmsapi);
        bt_sendintent=(Button)findViewById(R.id.sendsmsintent);
        bt_readsms=(Button)findViewById(R.id.readsms);
        lv=(ListView)findViewById(R.id.listView);
        bt_sendintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
            }
        });
        bt_sendapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("0943424", null, "dsadasd", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        bt_readsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Uri uri=Uri.parse("content://sms/inbox");
                //Uri uri=Uri.parse("content://sms/draft");
                Uri uri=Uri.parse("content://sms/sent");
                String[] from=new String[]{"_id","address","body"};
                Cursor cursor = getContentResolver().query(uri, from, null, null, null);

                ds.clear();
                if (cursor.moveToFirst()) { // must check the result to prevent exception
                    do {
                        ds.add(cursor.getColumnName(0) + ":" + cursor.getString(1)+ ":"+cursor.getString(2));

                    } while (cursor.moveToNext());
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,ds);
                    lv.setAdapter(adapter);
                } else {
// empty box, no SMS
                }
            }
        });



    }
}
