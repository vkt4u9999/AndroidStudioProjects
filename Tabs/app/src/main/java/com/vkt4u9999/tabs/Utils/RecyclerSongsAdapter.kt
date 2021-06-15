package com.vkt4u9999.tabs.Utils

import android.media.MediaPlayer
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.tabs.Model.Category
import com.vkt4u9999.tabs.Model.Song
import com.vkt4u9999.tabs.R
import kotlin.coroutines.coroutineContext

class RecyclerSongsAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerSongsAdapter.MyViewHolder>() {

    private var songs: List<Song> = ArrayList()
    private lateinit var cardParent: RecyclerSongsAdapter.MyViewHolder

    var mMediaPlayer: MediaPlayer?= null

    var songResource:Int?= null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var cardNameSong: TextView? = null

        init {
            itemView.setOnClickListener(this)
            cardNameSong = itemView.findViewById(R.id.cardNameSong)
        }


        fun bindSong(song: Song) = with(itemView) {
            cardNameSong?.text = song.songName
            songResource= song.songResource
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)

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





