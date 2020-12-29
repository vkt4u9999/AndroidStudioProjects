package com.vkt4u9999.reversewords;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputEditText = (EditText)findViewById(R.id.inputField);
        final TextView outputText = (TextView)findViewById(R.id.outputField);

        Button reverseButton = (Button)findViewById(R.id.reverseButton);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String outputLine = inputEditText.getText().toString();
                String[] words = outputLine.split(" ");
                StringBuilder str = new StringBuilder();
                for (String x : words) {
                    str.append(" " + HalfReverse.halfReverse(x, 'x', 'l'));
                    outputText.setText(str.toString());
                }
            }
        });
    }
}


