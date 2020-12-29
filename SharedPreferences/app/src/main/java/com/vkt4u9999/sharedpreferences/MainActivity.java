package com.vkt4u9999.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("mySharedPreferences",MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("newHelloText","HELLO SHARED PREFERENCES");
        //editor.remove("newHelloText");
        //editor.clear();
        editor.apply();


        TextView textView= findViewById(R.id.textView);
        textView.setText(sharedPreferences.getString("newHelloText","default Text"));
    }
}