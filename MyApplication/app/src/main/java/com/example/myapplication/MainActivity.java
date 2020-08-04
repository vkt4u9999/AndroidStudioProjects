package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private EditText mNameEditText;
    private Button mCrowsCountButton;
    private int mCount = 0;
    private TextView mInfoTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView= findViewById(R.id.textView);
        mNameEditText= findViewById(R.id.editTextTextPersonName);
        mCrowsCountButton=findViewById(R.id.button);
        mInfoTextView=findViewById(R.id.textView);


    }

    public void onClick(View view) {
        mHelloTextView.setText("Hello kitty");


        mCrowsCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText("Я насчитал " + ++mCount + " ворон");
            }
        });
            }
}
