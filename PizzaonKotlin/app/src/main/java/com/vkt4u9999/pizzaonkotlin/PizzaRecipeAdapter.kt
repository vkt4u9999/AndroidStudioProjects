package com.vkt4u9999.pizzaonkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PizzaRecipeAdapter(private val values: MutableList<PizzaRecipeItem>): RecyclerView.Adapter<PizzaRecipeAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PizzaRecipeAdapter.MyViewHolder, position: Int) {
        holder.imageView?.setImageResource(position)
        holder.nameTextView?.text= values[position]
        holder.descriptionTextView?.text= "КОТ"

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView:ImageView? = null
        var nameTextView: TextView? = null
        var descriptionTextView: TextView? = null

        init {
            imageView=itemView?.findViewById(R.id.imageView)
            nameTextView=itemView?.findViewById(R.id.nameTextView)
            descriptionTextView=itemView?.findViewById(R.id.descriptionTextView)
        }
    }

    override fun getItemCount()= values.size
}