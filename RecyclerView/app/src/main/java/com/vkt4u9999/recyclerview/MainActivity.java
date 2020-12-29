package com.vkt4u9999.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_satisfied_24,"Happy!", "Life is fun!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_very_dissatisfied_24,"Sad!", "Life is sad!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_baseline_sentiment_satisfied_24,".....!", "Life is life!"));

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter= new RecycleViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

}