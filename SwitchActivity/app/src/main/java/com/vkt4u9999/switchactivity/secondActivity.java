package com.vkt4u9999.switchactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String user = "Игорь";
        String gift = "шоколадный бублик";

        user = getIntent().getExtras().getString("username");
        gift = getIntent().getExtras().getString("gift");

        TextView infoTextView = (TextView)findViewById(R.id.infoTextView);
        infoTextView.setText("Ваше имя пользователя "+ user + " Ваш пароль "+ gift);
    }

}