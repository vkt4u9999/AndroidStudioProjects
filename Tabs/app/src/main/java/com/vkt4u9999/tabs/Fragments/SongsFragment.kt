package com.vkt4u9999.tabs.Fragments

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vkt4u9999.tabs.Model.SongViewModel
import com.vkt4u9999.tabs.R
import com.vkt4u9999.tabs.Utils.APP_ACTIVITY
import com.vkt4u9999.tabs.Utils.RecyclerSongsAdapter

class SongsFragment : Fragment(), RecyclerSongsAdapter.OnItemClickListener {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: RecyclerSongsAdapter
    private val songViewModel by lazy { ViewModelProviders.of(this).get(SongViewModel::class.java) }
    private lateinit var menuItem: MenuItem
    private lateinit var navView: BottomNavigationView


    var mMediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_songs, container, false)
        rv = view.findViewById(R.id.recyclerview)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerSongsAdapter(this)
        rv.adapter = adapter
        songViewModel.getListSong().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshSong(it)
            }
        })
        navView = view.findViewById(R.id.nav_view)
        setupNavigation()

        menuItem = navView.menu.findItem(R.id.play)



        return view
    }


    override fun onItemClick(position: Int) {

        if (mMediaPlayer == null || mMediaPlayer?.isPlaying == true || mMediaPlayer?.isPlaying == false) {
            var lastPosition: Int = -1
            when (position) {

                0 -> {
                    playWithChangingIcon(position, R.raw.dva_veselyh_gusya)
                    lastPosition = 0
                }
                1 -> {
                    playWithChangingIcon(position, R.raw.tridcatb_tri_korovy)
                    lastPosition = 1
                }

                2 -> {
                    playWithChangingIcon(position, R.raw.akuna_matata)
                    lastPosition = 2
                }
            }
        }


    }


    fun createMP(resource: Int) {
        mMediaPlayer = MediaPlayer.create(context, resource)
        mMediaPlayer?.start()
    }


    fun play() {
        if (mMediaPlayer?.isPlaying == true) {
            mMediaPlayer?.pause()
            menuItem.setIcon(R.drawable.ic_play)
        } else {
            mMediaPlayer?.start()
            menuItem.setIcon(R.drawable.ic_pause)
        }
    }


    fun playWithChangingIcon(position: Int, soundResource: Int) {
        var lastPosition: Int = -1
        if (mMediaPlayer?.isPlaying == true && lastPosition == position) {
            mMediaPlayer?.pause()
            menuItem.setIcon(R.drawable.ic_play)

        } else if (mMediaPlayer?.isPlaying == false && lastPosition == position) {
            mMediaPlayer?.start()
        } else {
            mMediaPlayer?.stop()
            releaseMp()
            createMP(soundResource)
            mMediaPlayer?.start()
            menuItem.setIcon(R.drawable.ic_pause)

        }

    }

    fun releaseMp() {
        if (mMediaPlayer != null) {
            mMediaPlayer?.release()
            mMediaPlayer = null
        }
    }

    fun setupNavigation() {

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.previous -> {
                    Toast.makeText(context, "Previous selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.play -> {
                    play()
                    Toast.makeText(context, "Play selected", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.next -> {
                    Toast.makeText(context, "Next selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
    }
}








