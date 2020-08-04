package com.vkt4u9999.reversewords;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class output extends AppCompatActivity {

    public String halfReverse(String string) {
        char[] charArray = string.toCharArray();
        ArrayList<Character> Char = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++)
            if (Character.isLetter(charArray[i])) {
                Char.add(charArray[i]);
                charArray[i] = 0;

            }
        Collections.reverse(Char);
        for (int i = 0, j = 0; i < charArray.length; i++)
            if (charArray[i] == 0)
                charArray[i] = Char.get(j++);
        return new String(charArray);
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        String inputLineText;


        inputLineText =getIntent().getExtras().getString("inputLine");
        TextView inputText2Act = (TextView)findViewById(R.id.input_text_2d_act);
        inputText2Act.setText(inputLineText);


        TextView outputText2Act = (TextView)findViewById(R.id.output_text_2d_act);


        String [] words = inputLineText.split(" ");
        for (String x : words)
            outputText2Act.setText(" " + halfReverse(x));
    }
}