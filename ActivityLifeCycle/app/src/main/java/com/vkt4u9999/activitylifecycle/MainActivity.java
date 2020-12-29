package com.vkt4u9999.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        textView.append("OnCreate"+ " \n");

        if (savedInstanceState != null){
            textView.setText(savedInstanceState.getString("textToBundle"));
        }
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        textView.append(textView.getText()+"getInstanceState \n");
        outState.putString("textToBundle", textView.getText().toString()+"wqwqww");


    }
}