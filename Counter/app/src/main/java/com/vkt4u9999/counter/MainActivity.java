package com.vkt4u9999.counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private MainActivityViewModel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData <Integer> countLiveData= model.getCurrentValue();
        countLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

    }

    public void decreaseValue(View view) {
        model.getDecreasedValue();
    }

    public void increaseValue(View view) {
        model.getIncreasedValue();
    }
}