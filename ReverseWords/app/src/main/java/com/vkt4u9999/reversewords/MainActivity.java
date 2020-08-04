package com.vkt4u9999.reversewords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {



    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, output.class);
        startActivity(intent);
        EditText inputEditText = (EditText)findViewById(R.id.input_line_1st_act);
        intent.putExtra("inputLine", inputEditText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}