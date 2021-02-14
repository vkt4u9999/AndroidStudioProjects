package com.vkt4u9999.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PizzaRecipeAdapter adapter;
    private GridLayoutManager layoutManager;
    private int columnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        columnCount=getResources().getInteger(R.integer.column_count);

        ArrayList<PizzaRecipeItem> pizzaRecipeItems = new ArrayList<>();
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_marghueritta, getResources().getString(R.string.pizza_1_name), getResources().getString(R.string.pizza_1_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_caramelised,  getResources().getString(R.string.pizza_2_name), getResources().getString(R.string.pizza_2_description),getResources().getString(R.string.pizza_2_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_syper_healthy,  getResources().getString(R.string.pizza_3_name), getResources().getString(R.string.pizza_3_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_sourdough,  getResources().getString(R.string.pizza_4_name), getResources().getString(R.string.pizza_4_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_chicken_tikka, getResources().getString(R.string.pizza_5_name), getResources().getString(R.string.pizza_5_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_pitta, getResources().getString(R.string.pizza_6_name), getResources().getString(R.string.pizza_6_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_rainbow, getResources().getString(R.string.pizza_7_name), getResources().getString(R.string.pizza_7_description),getResources().getString(R.string.pizza_1_recipe)));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_ultimate_marghueritta, getResources().getString(R.string.pizza_8_name), getResources().getString(R.string.pizza_9_description),getResources().getString(R.string.pizza_1_recipe)));

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter=new PizzaRecipeAdapter(pizzaRecipeItems,this);
        layoutManager=new GridLayoutManager(this,columnCount);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
