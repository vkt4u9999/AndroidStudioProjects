package com.vkt4u9999.reversewords;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public static String halfReverse(String string, Character... ignoreChar) {
        char[] charArray = string.toCharArray();
        List<Character> ignoreList = Arrays.asList(ignoreChar);
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++)
            if (!Character.isDigit(charArray[i]) && !ignoreList.contains(charArray[i])) {
                charList.add(charArray[i]);
                charArray[i] = 0;
            }
        Collections.reverse(charList);
        for (int i = 0, j = 0; i < charArray.length; i++)
            if (charArray[i] == 0)
                charArray[i] = charList.get(j++);
        return new String(charArray);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {

        EditText inputEditText = (EditText)findViewById(R.id.input_line);
        TextView outputText = (TextView)findViewById(R.id.outputText);
        String outputLine= inputEditText.getText().toString();
        String [] words = outputLine.split(" ");
        StringBuilder str= new StringBuilder();
        for(String x: words){
            str.append(" "+halfReverse(x, 'x','l'));
            outputText.setText(str.toString());
        }
    }
}


