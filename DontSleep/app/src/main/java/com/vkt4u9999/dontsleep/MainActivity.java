package com.vkt4u9999.dontsleep;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    void shuffleArray(String[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView secondTextView = findViewById(R.id.textView);
        final TextView thirdTextView = findViewById(R.id.textView2);
        ImageView leftImageButton = findViewById(R.id.imageView2);
        leftImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] phrases = {"Уже 6 часов утра, Сашка",
                        "Вставай, мы там всё уронили",
                        "Мы уронили вообще всё, Сашка, честно",
                        "Алексашка, ты чё опять лежишь?",
                        "Часики-то тикают",
                        "Покушать чудо-мужу сделала?",
                        "Златку покормила?", "Жопку помыла?", "Швепсика покормила?"};
                shuffleArray(phrases);


                secondTextView.setText(phrases[0]);
                thirdTextView.setText(phrases[1]);


            }
        });

    }
}