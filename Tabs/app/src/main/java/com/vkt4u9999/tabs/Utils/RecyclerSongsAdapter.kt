package com.vkt4u9999.tabs.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.tabs.Model.Song
import com.vkt4u9999.tabs.R

class RecyclerSongsAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerSongsAdapter.MyViewHolder>() {

    private var itemViewList = mutableListOf<View>()
    private var songs: List<Song> = ArrayList()
    private lateinit var cardParent: RecyclerSongsAdapter.MyViewHolder
    private lateinit var eqImageView: ImageView


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {


        var cardNameSong: TextView? = null
        var constraintLayout: ConstraintLayout

        init {
            itemView.setOnClickListener(this)
            cardNameSong = itemView.findViewById(R.id.cardNameSong)
            eqImageView = itemView.findViewById(R.id.equalizerImageView)
            constraintLayout = itemView.findViewById(R.id.constraintLayout)
            itemViewList.add(itemView)
        }


        fun bindSong(song: Song) = with(itemView) {
            cardNameSong?.text = song.songName

        }

        override fun onClick(view: View?) {


            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)

                for (tempItemView in itemViewList) {
                    if (itemViewList[adapterPosition] == tempItemView) {
                        tempItemView.setBackgroundResource(R.drawable.border);
                    } else {
                        tempItemView.setBackgroundResource(R.color.white);
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        cardParent = MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.songs_item, parent, false)
        )


        return cardParent
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindSong(songs[position])
    }


    override fun getItemCount() = songs.size


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun refreshSong(songs: List<Song>) {
        this.songs = songs
        notifyDataSetChanged()
    }


}





