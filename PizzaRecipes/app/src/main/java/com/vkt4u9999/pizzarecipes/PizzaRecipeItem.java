package com.vkt4u9999.pizzarecipes;


public class PizzaRecipeItem {
    private int imageResource;
    private String text1;
    private String text2;
    private String recipe;

    public PizzaRecipeItem(int imageResource, String text1, String text2, String recipe){
        this.imageResource=imageResource;
        this.text1=text1;
        this.text2=text2;
        this.recipe= recipe;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
    public String getRecipe() {
        return recipe;
    }
}
