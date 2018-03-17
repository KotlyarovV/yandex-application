package com.example.vitaly.yandexapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        List<String> items = initData();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(adapter);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();

        list.add("IPhone");
        list.add("HTC");
        list.add("Samsung");
        list.add("LG");

        return list;
    }
}
