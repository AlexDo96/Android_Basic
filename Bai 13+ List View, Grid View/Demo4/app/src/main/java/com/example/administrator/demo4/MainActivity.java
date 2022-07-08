package com.example.administrator.demo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView ex;
    List<Map<String, String>> groupData;
    List<List<Map<String, String>>> childData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ex=(ExpandableListView)findViewById(R.id.expandableListView);

        groupData = new ArrayList<Map<String, String>>();
        childData = new ArrayList<List<Map<String, String>>>();
        for (int i = 0; i < 20; i++) {
            Map<String, String> curGroupMap = new HashMap<String, String>();
            groupData.add(curGroupMap);
            curGroupMap.put("name", "Item " + i);

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
            for (int j = 0; j < 5; j++) {
                Map<String, String> curChildMap = new HashMap<String, String>();
                children.add(curChildMap);
                // curChildMap.put(NAME, "Child " + j);
                curChildMap.put("abc", "      sub " +j);
            }
            childData.add(children);
        }
        ExpandableListAdapter mAdapter;
        mAdapter=new SimpleExpandableListAdapter(
                MainActivity.this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { "name"},
                new int[] { android.R.id.text1},
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { "abc"},
                new int[] { android.R.id.text1}
        );
        ex.setAdapter(mAdapter);

    }
}
