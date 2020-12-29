package com.vkt4u9999.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PizzaRecipeAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<PizzaRecipeItem> pizzaRecipeItems = new ArrayList<>();
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_marghueritta, PizzaDetails.PIZZA_1_TITLE, PizzaDetails.PIZZA_1_DESCRIPTION,PizzaDetails.PIZZA_1_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_caramelised, PizzaDetails.PIZZA_2_TITLE, PizzaDetails.PIZZA_2_DESCRIPTION,PizzaDetails.PIZZA_2_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_syper_healthy, PizzaDetails.PIZZA_3_TITLE, PizzaDetails.PIZZA_3_DESCRIPTION,PizzaDetails.PIZZA_3_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_sourdough, PizzaDetails.PIZZA_4_TITLE,PizzaDetails.PIZZA_4_DESCRIPTION,PizzaDetails.PIZZA_4_RECIPE ));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_chicken_tikka,PizzaDetails.PIZZA_5_TITLE,PizzaDetails.PIZZA_5_DESCRIPTION,PizzaDetails.PIZZA_5_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_pitta,PizzaDetails.PIZZA_6_TITLE, PizzaDetails.PIZZA_6_DESCRIPTION,PizzaDetails.PIZZA_6_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_rainbow,PizzaDetails.PIZZA_7_TITLE,PizzaDetails.PIZZA_7_DESCRIPTION,PizzaDetails.PIZZA_7_RECIPE ));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_ultimate_marghueritta,PizzaDetails.PIZZA_8_TITLE,PizzaDetails.PIZZA_8_DESCRIPTION,PizzaDetails.PIZZA_8_RECIPE ));

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter=new PizzaRecipeAdapter(pizzaRecipeItems,this);
        layoutManager=new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
