package com.vkt4u9999.galaxybilliard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    String goodsName;
    HashMap goodsMap;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createHashMap();



    }

    public void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList= new ArrayList();
        spinnerArrayList.add("Мел для бильярда");
        spinnerArrayList.add("Кии");
        spinnerArrayList.add("Чехлы, тубусы");
        spinnerArrayList.add("Наклейки");
        spinnerArrayList.add("Перчатки");
        spinnerAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void createHashMap(){
        goodsMap = new HashMap();
        goodsMap.put("chalk_predator", 10);
        goodsMap.put("chalk_blue_diamond", 15);
        goodsMap.put("chalk_master", 2);
        goodsMap.put("chalk_super_diamond", 55);
        goodsMap.put("mv_eben_grab", 1255);
        goodsMap.put("mv_cue_flower_vengepaduk", 875);
        goodsMap.put("mv_grab_makassar", 1180);
        goodsMap.put("mv_venge_grab", 655);
        goodsMap.put("tubus_predator", 170);
        goodsMap.put("tubus_sniper", 80);
        goodsMap.put("tubus_ankara", 370);
        goodsMap.put("tubus_predator_ikon", 195);
        goodsMap.put("nakleyka_blue_knight", 10);
        goodsMap.put("nakleyka_moori_h", 55);
        goodsMap.put("nakleyka_triangl", 5);
        goodsMap.put("nakleyka_kamui_pyramid_black", 70);
        goodsMap.put("perchatka_kamui_quickdry_black", 65);
        goodsMap.put("perchatka_longoni_black_sultan", 65);
        goodsMap.put("perchatka_longoni_military", 65);
        goodsMap.put("perchatka_renzline_billard", 65);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName= spinner.getSelectedItem().toString();

        ImageView goodsImageView1 = findViewById(R.id.chalk_predator);
        ImageView goodsImageView2= findViewById(R.id.chalk_blue_diamond);
        ImageView goodsImageView3 = findViewById(R.id.chalk_master);
        ImageView goodsImageView4 = findViewById(R.id.chalk_super_diamond);
        TextView nameOfGoodsTextView1 = findViewById(R.id.nameOfGoodsTextView1);
        TextView nameOfGoodsTextView2 = findViewById(R.id.nameOfGoodsTextView2);
        TextView nameOfGoodsTextView3 = findViewById(R.id.nameOfGoodsTextView3);
        TextView nameOfGoodsTextView4 = findViewById(R.id.nameOfGoodsTextView4);
        TextView price1 = findViewById(R.id.price1);
        TextView price2 = findViewById(R.id.price2);
        TextView price3 = findViewById(R.id.price3);
        TextView price4 = findViewById(R.id.price4);


        if (goodsName.equals("Кии")){
            goodsImageView1.setImageResource(R.drawable.mv_eben_grab);
            goodsImageView2.setImageResource(R.drawable.mv_cue_flower_vengepaduk);
            goodsImageView3.setImageResource(R.drawable.mv_grab_makassar);
            goodsImageView4.setImageResource(R.drawable.mv_venge_grab);
            nameOfGoodsTextView1.setText(R.string.mv_eben_grab);
            nameOfGoodsTextView2.setText(R.string.mv_cue_flower_vengepaduk);
            nameOfGoodsTextView3.setText(R.string.mv_grab_makassar);
            nameOfGoodsTextView4.setText(R.string.mv_venge_grab);
            price1.setText("1255");
            price2.setText("875");
            price3.setText("1180");
            price4.setText("655");

        }
        else if (goodsName.equals("Мел для бильярда")){
            goodsImageView1.setImageResource(R.drawable.chalk_predator);
            goodsImageView2.setImageResource(R.drawable.chalk_blue_diamond);
            goodsImageView3.setImageResource(R.drawable.chalk_master);
            goodsImageView4.setImageResource(R.drawable.chalk_super_diamond);
            nameOfGoodsTextView1.setText(R.string.chalk_predator);
            nameOfGoodsTextView2.setText(R.string.chalk_blue_diamond);
            nameOfGoodsTextView3.setText(R.string.chalk_master);
            nameOfGoodsTextView4.setText(R.string.chalk_super_diamond);
            price1.setText("10");
            price2.setText("15");
            price3.setText("2");
            price4.setText("55");
        }
        else if (goodsName.equals("Чехлы, тубусы")){
            goodsImageView1.setImageResource(R.drawable.tubus_predator);
            goodsImageView2.setImageResource(R.drawable.tubus_sniper);
            goodsImageView3.setImageResource(R.drawable.tubus_ankara);
            goodsImageView4.setImageResource(R.drawable.tubus_predator_ikon);
            nameOfGoodsTextView1.setText(R.string.tubus_predator);
            nameOfGoodsTextView2.setText(R.string.tubus_sniper);
            nameOfGoodsTextView3.setText(R.string.tubus_ankara);
            nameOfGoodsTextView4.setText(R.string.tubus_predator_ikon);
            price1.setText("170");
            price2.setText("80");
            price3.setText("370");
            price4.setText("195");
        }
        else if (goodsName.equals("Наклейки")){
            goodsImageView1.setImageResource(R.drawable.nakleyka_blue_knight);
            goodsImageView2.setImageResource(R.drawable.nakleyka_moori_h);
            goodsImageView3.setImageResource(R.drawable.nakleyka_triangl);
            goodsImageView4.setImageResource(R.drawable.nakleyka_kamui_pyramid_black);
            nameOfGoodsTextView1.setText(R.string.nakleyka_blue_knight);
            nameOfGoodsTextView2.setText(R.string.nakleyka_moori_h);
            nameOfGoodsTextView3.setText(R.string.nakleyka_triangl);
            nameOfGoodsTextView4.setText(R.string.nakleyka_kamui_pyramid_black);
            price1.setText("10");
            price2.setText("55");
            price3.setText("10");
            price4.setText("70");
        }
        else if (goodsName.equals("Перчатки")){
            goodsImageView1.setImageResource(R.drawable.perchatka_kamui_quickdry_black);
            goodsImageView2.setImageResource(R.drawable.perchatka_longoni_black_sultan);
            goodsImageView3.setImageResource(R.drawable.perchatka_longoni_military);
            goodsImageView4.setImageResource(R.drawable.perchatka_renzline_billard);
            nameOfGoodsTextView1.setText(R.string.perchatka_kamui_quickdry_black);
            nameOfGoodsTextView2.setText(R.string.perchatka_longoni_black_sultan);
            nameOfGoodsTextView3.setText(R.string.perchatka_longoni_military);
            nameOfGoodsTextView4.setText(R.string.perchatka_renzline_billard);
            price1.setText("65");
            price2.setText("65");
            price3.setText("65");
            price4.setText("65");
        }
        }




    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


    public void addToCard(){

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(orderIntent);

    }

    public void createOrder(View view) {
        addToCard();
    }
}