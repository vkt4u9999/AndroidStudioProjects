package com.vkt4u9999.sherlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final private int CHOOSE_THIEF= 0;

    public void onClick(View view) {
        Intent questionIntent = new Intent(MainActivity.this, ChooseActivity.class );
        startActivityForResult(questionIntent,CHOOSE_THIEF);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        TextView infoTextView = (TextView)findViewById(R.id.textViewLabel);

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                String thiefName = data.getStringExtra(ChooseActivity.THIEF);
                infoTextView.setText(thiefName);
            }else {
                infoTextView.setText(""); // стираем текст
            }
        }
    }
    }


