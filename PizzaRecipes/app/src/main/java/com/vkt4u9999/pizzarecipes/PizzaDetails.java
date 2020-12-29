package com.vkt4u9999.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PizzaDetails extends AppCompatActivity {

    public static final String PIZZA_1_TITLE="Next level Margherita  pizza";
    public static final String PIZZA_1_DESCRIPTION="Forget takeaways – you can’t beat a homemade Margherita pizza topped with fresh tomato sauce and melted cheese. Here's how to master this everyday classic...";
    public static final String PIZZA_1_RECIPE="STEP 1\n" +
            "First, make the dough. Tip the flour into a bowl and add 300ml tepid water. Mix together and set aside at room temperature for 1 hr. Dissolve the yeast in 2 tbsp water and mix this and 15g of salt through the dough. Cover with cling film and leave somewhere warm to double in size for a few hours. For a sourer flavour, leave in the fridge for at least 8 hrs and up to 24 hrs – the longer you leave it the sourer it will be.\n" +
            "\n" +
            "STEP 2\n" +
            "When the dough is ready, tip it onto a lightly floured surface and divide into four. Roll into balls and leave to rest, covered with a tea towel or cling film for another hour.\n" +
            "\n" +
            "STEP 3\n" +
            "Now make the tomato sauce. Drain some of the juice from the can and tip the rest into a bowl with the olive oil, oregano and a generous pinch of salt, then either scrunch everything together with your fingers for a chunky sauce or blitz with a stick blender if you want it smooth. Tie the basil stalks together, bruise with the back of a knife and place in the sauce. Leave the sauce at room temperature until needed.\n" +
            "\n" +
            "STEP 4\n" +
            "To make the pizza, heat a grill to its highest setting and get a heavy frying pan. On a floured surface push and stretch one of the balls of dough out into a circle roughly the same size as the frying pan. Slip the round onto a floured baking sheet and top with a quarter of the sauce, a scattering of cheese, a few basil leaves and a quarter of the mozzarella.\n" +
            "\n" +
            "STEP 5\n" +
            "Get the pan very hot and carefully slide the pizza onto it. Cook for 2 mins, then put the pan under the grill for another 2 mins until the sides are puffed up and the cheese has melted. Lift onto a board, drizzle with a little olive oil if you like, then cut into wedges and serve while you make the next one.";

    public static final String PIZZA_2_TITLE="Caramelised onion & goat’s cheese pizza";
    public static final String PIZZA_2_DESCRIPTION="Make a veggie pizza that's healthy and low-fat instead of ordering a takeaway. This easy recipe uses goat's cheese for tang while the onions give it sweetness";
    public static final String PIZZA_2_RECIPE="STEP 1\n" +
            "Heat oven to 220C/200C fan/gas 7. Tip the flour into a mixer with a dough hook, or a bowl. Add the yeast, salt, oil and just under 100ml warm water then mix to a soft dough. Knead in the food mixer for about 5 mins, but if making this by hand, tip onto a work surface and knead for about 10 mins. The dough is sticky, but try not to add too much extra flour. Leave in the bowl and cover with a tea towel while you make the topping. There is no need to let the dough prove for a specific time – just let it sit while you get on with the next step.\n" +
            "\n" +
            "STEP 2\n" +
            "Tip the onions into a non-stick wok and add the oil, 4 tbsp water and balsamic vinegar. Cover with a saucepan lid that sits inside the pan to help the onions soften, then cook for 15 mins, stirring about 3 times and replacing the lid quickly so as not to lose too much moisture. After the time is up, the onions should be golden and all the liquid gone. Tip onto a plate. Add the spinach and garlic to the pan and stir-fry until the spinach has wilted.\n" +
            "\n" +
            "STEP 3\n" +
            "Take the dough from the bowl and cut in half with an oiled knife, then press each piece into a 25-15 cm oval on a large greased baking sheet with oiled hands. Don’t knead the dough first otherwise it will be too elastic and it will keep shrinking back.\n" +
            "\n" +
            "STEP 4\n" +
            "Spread with the spinach followed by the onions, then dot with the cheese and scatter with the olives, thyme and sunflower seeds. Bake for 15 mins until golden and the base is cooked through.";

    public static final String PIZZA_3_TITLE="Superhealthy pizza";
    public static final String PIZZA_3_DESCRIPTION="The quantities for this are generous, so if you have any leftovers, pop a wedge of cold pizza into your lunchbox the next day";
    public static final String PIZZA_3_RECIPE="STEP 1\n" +
            "Mix the flours and yeast with a pinch of salt in a food processor fitted with a dough blade. Pour in the water and mix to a soft dough, then work for 1 min. Remove the dough and roll out on a lightly floured surface to a round about 30cm across. Lift onto an oiled baking sheet.\n" +
            "\n" +
            "STEP 2\n" +
            "Spread the canned tomatoes over the dough to within 2cm of the edges. Arrange the cherry tomatoes and courgettes over the top, then scatter with the mozzarella. Mix the capers, olives and garlic, then scatter over the top. Drizzle evenly with the oil. Leave to rise for 20 mins. Heat oven to 240C/ fan 220C/gas 9 or the highest setting.\n" +
            "\n" +
            "STEP 3\n" +
            "Bake the pizza for 10-12 mins until crisp and golden around the edges. Scatter with the parsley to serve.";

    public static final String PIZZA_4_TITLE="Sourdough pizza";
    public static final String PIZZA_4_DESCRIPTION="Make homemade sourdough pizza with a wonderfully chewy crust. Try our margherita recipe, then customise with your favourite toppings";
    public static final String PIZZA_4_RECIPE="STEP 1\n" +
            "Make a batch of our white sourdough, following the recipe to the end of step 4. When the dough is ready, tip it onto a lightly floured surface and divide into six equal pieces. Roll into balls and leave to rest on a floured tray, covered with a damp teatowel, in the fridge for at least 4 hrs, and up to 18 hrs – the longer you leave the dough, the more sour it will taste.\n" +
            "\n" +
            "STEP 2\n" +
            "Meanwhile, make the tomato sauce. Drain some of the juice from the plummed tomatoes and tip the rest into a bowl with the olive oil, oregano and a generous pinch of salt. Combine by either scrunching everything together with your fingers (this will make a chunky sauce) or blitz with a stick blender (this will make a smooth sauce). Chill until needed.\n" +
            "\n" +
            "STEP 3\n" +
            "To make the pizzas, heat a grill to high and prepare an ovenproof frying pan. On a floured surface, push and stretch a ball of dough into a circle roughly the same size as the pan. Get the pan very hot, then working quickly and carefully, drape it into the pan, spread over some of the sauce, a handful of mozzarella and some basil, if using.  \n" +
            "\n" +
            "STEP 4\n" +
            "Cook for 2 mins, until little bubbles appear, then put the pan under the grill for another 2-4 mins until the sides are puffed up and the cheese has melted. Remove, drizzle with a little olive oil and cut into wedges. Repeat with the remaining dough. ";

    public static final String PIZZA_5_TITLE="Chicken tikka";
    public static final String PIZZA_5_DESCRIPTION="Rustle up our spiced chicken pizzas using naan bread in just 20 minutes. To balance the heat, serve them with dollops of mango chutney and natural yogurt";
    public static final String PIZZA_5_RECIPE="STEP 1\n" +
            "Heat oven to 180C/160C fan/gas 4. Toss the red onion with the red wine vinegar and a good pinch of salt and set aside (the vinegar will soften the onion slightly, which is a blessing as no one wants completely raw onion on pizza).\n" +
            "\n" +
            "STEP 2\n" +
            "Put the naan breads on a baking tray, sprinkle over a little water, then put in the oven for 2 mins to heat up. Meanwhile, put the chicken and peppers in a frying pan with the curry paste, toss together, then fry over a high heat for 6-8 mins until cooked.\n" +
            "\n" +
            "STEP 3\n" +
            "Take the naans out the oven, spread each one with yogurt, then top with the chicken, red onion, green chilli, coriander and mango chutney.";

    public static final String PIZZA_6_TITLE="Pitta pizza";
    public static final String PIZZA_6_DESCRIPTION="Little ones will love these fun and super-easy pizza's for lunch or a light supper";
    public static final String PIZZA_6_RECIPE="STEP 1\n" +
            "Heat the grill. Spread each pitta bread with 1 tbsp tomato purée, sprinkle over the mixed herbs, then lay on the tomato slices. Divide the salami between the pittas, sprinkle over the cheese and grill until the cheese is golden and bubbling.";

    public static final String PIZZA_7_TITLE="Rainbow Pizza";
    public static final String PIZZA_7_DESCRIPTION="Forget takeaway pizzas, encourage kids to eat a rainbow every day with this colourful recipe full of fresh flavours – guaranteed to please even fussy eaters";
    public static final String PIZZA_7_RECIPE="STEP 1\n" +
            "Heat the oven to 180C/160C fan/gas 4. Put each pizza base on a baking sheet and spread each with half of the passata. Arrange the tomatoes on the top in rings or wedges of colour and add the broccoli and the olives, if using. Squish the mozzarella cherries (bocconcini) a little before dotting them over the pizzas, then drizzle 1 tbsp pesto over each.\n" +
            "\n" +
            "STEP 2\n" +
            "Bake for 15-20 mins or until the top is bubbling and just starting to brown a little. Scatter over the basil leaves before serving.";

    public static final String PIZZA_8_TITLE="Ultimate marghueritta pizza";
    public static final String PIZZA_8_DESCRIPTION="Take your senses on a trip to Italy with this authentic pizza Margherita";
    public static final String PIZZA_8_RECIPE="STEP 1\n" +
            "In a bowl, mix flour, semolina, salt and yeast. Make a dip in the middle, pour in oil, water, then stir and squeeze everything together (hands are easiest for this). The dough should feel very sticky (pic 1). When it is well mixed, cover and leave for 15 mins.\n" +
            "\n" +
            "STEP 2\n" +
            "Tip the dough on to a lightly oiled work surface and rub your hands and the inside of the bowl with oil. Knead the dough about 12 times only, giving it a quarter turn each time you knead. Tuck the ends under so it is the shape of a ball and lay it in the bowl, seam side down. Cover and leave for 10 mins. Repeat the kneading and leaving for 10 mins again, then knead and leave for 15 mins, oiling the surface and your hands each time.\n" +
            "\n" +
            "STEP 3\n" +
            "In between kneadings make the sauce for the topping. Drain the tomatoes and tip them into a bowl. Snip them into small pieces with scissors (pic 2). Stir in garlic, tomato purée, and seasoning. Set aside. Brush a baking sheet with oil and sprinkle with a little semolina. Heat oven to 240C/fan 220C/gas 9.\n" +
            "\n" +
            "STEP 4\n" +
            "When the dough is ready, cut in half and put one half onto a lightly fl oured surface. Knead 4-5 times to squash out any air bubbles, then roll it out. At the point where it just keeps springing back, brush off the flour from the work surface and rub on a little oil. This makes it easier to roll. Continue to roll out until you have a 28cm circle, pulling it into shape as well. Lift it onto the baking sheet (it’s easier if you drape it over a rolling pin).\n" +
            "\n" +
            "STEP 5\n" +
            "Drain the mozzarella, then pat dry with kitchen paper. Brush the dough with olive oil, then spread half the sauce over, almost up to the edge. Scatter over half the basil, then tear up one mozzarella ball and scatter over the basil (pic 3). Grate over pepper and drizzle with a little oil. Bake for 12-15 mins, until the topping is bubbling and the dough is going brown. Repeat with the remaining dough and toppings. To serve, scatter with parmesan shavings, rocket leaves and drizzle with oil.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_details);

        TextView title= findViewById(R.id.titleTextView);
        TextView recipe = findViewById(R.id.recipeTextView);
        ImageView imageView= findViewById(R.id.fullImageView);



        Intent intent=getIntent();
        if (intent!= null){

            title.setText(intent.getStringExtra("title"));
            recipe.setText(intent.getStringExtra("recipe"));
           imageView.setImageResource(getIntent().getIntExtra("imageResource", R.drawable.pizza_marghueritta));

        }
    }
}