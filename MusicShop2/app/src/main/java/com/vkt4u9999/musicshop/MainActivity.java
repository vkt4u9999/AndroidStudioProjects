package com.vkt4u9999.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int setQuantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    Double price;
    EditText userNameEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.editTextPersonName);

        createSpinner();

        createHashMap();
    }

    public void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("violin");
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("piano");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void createHashMap(){
        goodsMap = new HashMap();
        goodsMap.put("violin", 1999.0);
        goodsMap.put("guitar", 600.0);
        goodsMap.put("drums", 1199.0);
        goodsMap.put("piano", 1499.0);
    }

    public void buttonPlus(View view) {
        setQuantity = setQuantity + 1;
        TextView quantity = findViewById(R.id.quantity);
        quantity.setText("" + setQuantity);
        TextView priceTextView = findViewById(R.id.price_num);
        priceTextView.setText("" + setQuantity*price);
    }
    public void buttonMinus(View view) {
        setQuantity = setQuantity - 1;
        TextView quantity = findViewById(R.id.quantity);

        if (setQuantity<0)
            setQuantity = 0;
        else
        quantity.setText("" + setQuantity);
        TextView priceTextView = findViewById(R.id.price_num);
        priceTextView.setText("" + setQuantity*price);
}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         goodsName= spinner.getSelectedItem().toString();
         price = (double)goodsMap.get(goodsName);
         TextView priceTextView = findViewById(R.id.price_num);
         priceTextView.setText("" + setQuantity*price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        if (goodsName.equals("violin")){
            goodsImageView.setImageResource(R.drawable.violin);
        }
        else if (goodsName.equals("guitar")){
            goodsImageView.setImageResource(R.drawable.guitar);
        }
        else if (goodsName.equals("drums")){
            goodsImageView.setImageResource(R.drawable.drums);
        }
        else if (goodsName.equals("piano")){
            goodsImageView.setImageResource(R.drawable.piano);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCard(View view) {
        Order order = new Order();

        order.userName = userNameEditText.getText().toString();
        order.goodsNames= goodsName;
        order.quantity= setQuantity;
        order.orderPrice= setQuantity*price;

        Intent orderIntent= new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userNameForIntent", order.userName);
        orderIntent.putExtra("goodsNameForIntent", order.goodsNames);
        orderIntent.putExtra("quantityForIntent", order.quantity);
        orderIntent.putExtra("orderPriceForIntent", order.orderPrice);
        startActivity(orderIntent);




    }
}