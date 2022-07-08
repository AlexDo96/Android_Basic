package com.example.administrator.demo2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HaiActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hai);
        tv=(TextView)findViewById(R.id.textView);

        ContentResolver ctr=getContentResolver();
        Cursor c=ctr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String chuoi="";
        if(c.getCount()>0)
        {
            while (c.moveToNext())
            {
                String id=c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String ten=c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                chuoi+= id + " " + ten;

                if(Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0)
                {
                    String where=ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?";
                    String mangwhere[]=new String[]{id};
                    Cursor dt=ctr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,where,mangwhere,null);
                    if(dt.getCount()>0) {
                        while (dt.moveToNext()) {
                            String so=dt.getString(dt.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            chuoi+=so + " ";
                        }
                    }
                }

                chuoi+="\n";

            }

        }
        tv.setText(chuoi);
    }
}
