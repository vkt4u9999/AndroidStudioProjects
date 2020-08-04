package com.vkt4u9999.sherlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }
    public final static String THIEF = "com.vkt4u9999.sherlock.THIEF";

    public void onRadioClick(View v) {
        Intent answerIntent = new Intent();

        switch (v.getId()) {
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Сраный пёсик");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "Ворона");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "Лошадь Пржевальского");
                break;

            default:
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }
}