package com.vkt4u9999.cardsandmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val categoryName: List<String>, private  val imageResource: List<Int>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView? = null
        var cardNameCategory: TextView? = null

        init {
            imageView = itemView.findViewById(R.id.cardImageView)
            cardNameCategory = itemView.findViewById(R.id.cardNameCategory)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cardNameCategory?.text= categoryName[position]
        holder.imageView?.setImageResource(imageResource[position])
    }

    override fun getItemCount() = categoryName.size

}