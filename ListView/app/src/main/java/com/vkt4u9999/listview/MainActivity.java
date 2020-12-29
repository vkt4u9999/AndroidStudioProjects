package com.vkt4u9999.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList <String> posts= new ArrayList<>();

        posts.add("Красный");
        posts.add("Оранжевый");
        posts.add("Желтый");
        posts.add("Зеленый");
        posts.add("Голубой");
        posts.add("Синий");
        posts.add("Бирюзовый>");
        posts.add("алдоылоаыв");
        posts.add("выаыа");
        posts.add("Фиолаываывветовый");
        posts.add("ыаыаы");
        posts.add("Фиолетовый");
        posts.add("аываы");
        posts.add("выаыва");
        posts.add("ываыаы");
        posts.add("Фиолетовый");
        posts.add("Фиолетовый");
        posts.add("Фиолетовый");
        posts.add("ыаыва");

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,posts);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+posts.get(i)+" - "+ i, Toast.LENGTH_SHORT).show();
                view.setVisibility(View.GONE);
            }
        });
    }

}