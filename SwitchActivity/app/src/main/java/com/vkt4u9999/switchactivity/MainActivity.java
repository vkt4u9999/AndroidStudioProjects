package com.vkt4u9999.switchactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){

        EditText userEditText = findViewById(R.id.userTextView);
        EditText giftEditText = findViewById(R.id.passwordTextView);
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        startActivity(intent);

        // в ключ username пихаем текст из первого текстового поля
        intent.putExtra("username", userEditText.getText().toString());
        // в ключ gift пихаем текст из второго текстового поля
        intent.putExtra("gift", giftEditText.getText().toString());
        startActivity(intent);

    }
}