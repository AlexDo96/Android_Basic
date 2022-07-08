package com.example.administrator.listviewcustom1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String []ten={ "kim hee sun","kim nam joo",
            "kim so eun","kim tae hee",
            "kim chi","kimbap",
            "kim hee sun","kim nam joo",
            "kim so eun", "kim tae hee",
            "kim chi","kimbap"

    };
    int []hinh={ R.drawable.kimheesun,R.drawable.kimnamjoo,
            R.drawable.kimsoeun,R.drawable.kimtaehee,
            R.drawable.kimchi,R.drawable.kimbap,

            R.drawable.kimheesun,R.drawable.kimnamjoo,
            R.drawable.kimsoeun,R.drawable.kimtaehee,
            R.drawable.kimchi,R.drawable.kimbap
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listView);

        MyAdapter adapter=new MyAdapter(MainActivity.this,ten,hinh);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // lv.getItemIdAtPosition(position); //getItemId
               // lv.getItemAtPosition(position);//getItem
                Toast.makeText(MainActivity.this,ten[position],Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void xuly()
    {
        Toast.makeText(MainActivity.this,"goi toi ham activity",Toast.LENGTH_SHORT).show();
    }
}
