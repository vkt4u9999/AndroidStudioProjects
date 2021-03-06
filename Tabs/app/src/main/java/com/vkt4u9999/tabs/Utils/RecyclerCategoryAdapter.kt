package com.vkt4u9999.tabs.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.tabs.Model.Category
import com.vkt4u9999.tabs.R

class RecyclerCategoryAdapter(
private val listener: OnItemClickListener
) :
RecyclerView.Adapter<RecyclerCategoryAdapter.MyViewHolder>() {

    private var categories: List<Category> = ArrayList()
    private lateinit var  cardParent: RecyclerCategoryAdapter.MyViewHolder

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var imageView: ImageView? = null
        var cardNameCategory: TextView? = null

        init {
            itemView.setOnClickListener(this)
            imageView = itemView.findViewById(R.id.cardImageView)
            cardNameCategory = itemView.findViewById(R.id.cardNameCategory)
        }

        fun bindCategory(category: Category) = with(itemView) {
            imageView?.setImageResource(category.imageResource)
            cardNameCategory?.text = category.categoryName
        }

        override fun onClick(p0: View?) {

            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        cardParent=MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.categories_item, parent, false)

        )

        return cardParent
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindCategory(categories[position])


    }

    override fun getItemCount() = categories.size

    fun refreshCategory(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}
