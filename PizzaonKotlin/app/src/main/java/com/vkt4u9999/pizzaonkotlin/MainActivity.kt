package com.vkt4u9999.pizzaonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var columnCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        columnCount= 1;

        var pizzaRecipeItem= mutableListOf<PizzaRecipeItem>()
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_caramelised,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_chicken_tikka,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_marghueritta,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_pitta,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_rainbow,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_sourdough,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_syper_healthy,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))
        pizzaRecipeItem.add(PizzaRecipeItem(R.drawable.pizza_ultimate_marghueritta,"Caramel pizza","Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here\\'s how to master this everyday classic…"))



        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.hasFixedSize()

        recyclerView.adapter=PizzaRecipeAdapter(pizzaRecipeItem)

    }

}