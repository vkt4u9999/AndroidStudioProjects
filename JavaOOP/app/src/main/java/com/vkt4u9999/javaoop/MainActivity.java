package com.vkt4u9999.javaoop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Movable movable = new Cat();
        movable.catGrow();

        Animal cat1= new Cat();
        cat1.catGrow();

    }
}
