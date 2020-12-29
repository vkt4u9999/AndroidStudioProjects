package com.vkt4u9999.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecipeAdapter extends RecyclerView.Adapter<PizzaRecipeAdapter.RecycleViewHolder> {

    ArrayList<PizzaRecipeItem> arrayList;
    Context context;
    public PizzaRecipeAdapter(ArrayList<PizzaRecipeItem> arrayList, Context context){
        this.arrayList=arrayList;
        this.context= context;
    }

    @NonNull
    @Override
    public PizzaRecipeAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);

        RecycleViewHolder recycleViewHolder= new RecycleViewHolder(view);
        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecipeAdapter.RecycleViewHolder holder, int position) {


        PizzaRecipeItem pizzaRecipeItem =arrayList.get(position);
        holder.imageView.setImageResource(pizzaRecipeItem.getImageResource());
        holder.textView1.setText(pizzaRecipeItem.getText1());
        holder.textView2.setText(pizzaRecipeItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;


        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageView=itemView.findViewById(R.id.imageView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View view) {

            int position= getAdapterPosition();
            PizzaRecipeItem pizzaRecipeItem= arrayList.get(position);

            Intent intent = new Intent(context,PizzaDetails.class);
            intent.putExtra("imageResource", pizzaRecipeItem.getImageResource());
            intent.putExtra("title", pizzaRecipeItem.getText1());
            intent.putExtra("description", pizzaRecipeItem.getText2());
            intent.putExtra("recipe", pizzaRecipeItem.getRecipe());

            context.startActivity(intent);
        }
    }
}
