package com.vkt4u9999.tabs.Fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vkt4u9999.tabs.Model.SongViewModel
import com.vkt4u9999.tabs.R
import com.vkt4u9999.tabs.Utils.RecyclerSongsAdapter
import java.util.*

class SongsFragment : Fragment(), RecyclerSongsAdapter.OnItemClickListener {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: RecyclerSongsAdapter
    private val songViewModel by lazy { ViewModelProviders.of(this).get(SongViewModel::class.java) }
    private lateinit var menuItem: MenuItem
    private lateinit var navView: BottomNavigationView
    private lateinit var seekBar: SeekBar
    private lateinit var audioFiles: List<Int>
    private var lastPosition: Int = 0
    var mMediaPlayer: MediaPlayer? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_songs, container, false)

        initFunc(view)
        setupNavigation()


        return view
    }

    fun initFunc(view: View) {
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
        seekBar = view.findViewById(R.id.seekBar)


        menuItem = navView.menu.findItem(R.id.play)
        audioFiles = listOf(R.raw.dva_veselyh_gusya, R.raw.tridcatb_tri_korovy, R.raw.akuna_matata)
    }

    fun setupSeekBar() {
        seekBar.max = mMediaPlayer?.duration!!

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mMediaPlayer?.seekTo(i)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })



        Timer().scheduleAtFixedRate(object : TimerTask() {

            override fun run() {
                seekBar.progress = mMediaPlayer?.currentPosition!!

            }
        }, 0, 1000)
    }


    override fun onItemClick(position: Int) {

        // if (mMediaPlayer == null || mMediaPlayer?.isPlaying == true || mMediaPlayer?.isPlaying == false) {
        when (position) {

            0 -> {
                playWithChangingIcon(position, audioFiles[0])
                setupSeekBar()
                lastPosition = 0
            }
            1 -> {
                playWithChangingIcon(position, audioFiles[1])
                setupSeekBar()
                lastPosition = 1
            }

            2 -> {
                playWithChangingIcon(position, audioFiles[2])
                setupSeekBar()
                lastPosition = 2
            }
        }
        //}


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
        // var lastPosition: Int = -1
        if (mMediaPlayer?.isPlaying == true && lastPosition == position) {

            mMediaPlayer?.pause()
            menuItem.setIcon(R.drawable.ic_play)


        } else if (mMediaPlayer?.isPlaying == false && lastPosition == position) {
            mMediaPlayer?.start()
        } else {
            mMediaPlayer?.stop()
            mMediaPlayer?.reset()
            releaseMp()
            createMP(soundResource)
            mMediaPlayer?.start()
            menuItem.setIcon(R.drawable.ic_pause)

        }

    }

    fun releaseMp() {
        if (mMediaPlayer != null) {
            mMediaPlayer?.stop()
            mMediaPlayer?.reset()
            mMediaPlayer?.release()
            mMediaPlayer = null
        }
    }


    fun setupNavigation() {

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.previous -> {

                    if (lastPosition >= 1) {
                        mMediaPlayer?.selectTrack(audioFiles[lastPosition--])
                        mMediaPlayer?.stop()
                        releaseMp()
                        createMP(audioFiles[lastPosition])
                        mMediaPlayer?.start()
                    } else {
                        Toast.makeText(context, "Это самая первая песня", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.play -> {
                    if (mMediaPlayer == null) {
                        createMP(audioFiles[lastPosition])
                        mMediaPlayer?.start()
                        menuItem.setIcon(R.drawable.ic_pause)
                        setupSeekBar()
                    } else play()


                    Toast.makeText(context, "Play selected", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.next -> {
                    if (lastPosition <= 1) {
                        mMediaPlayer?.selectTrack(audioFiles[lastPosition++])
                        mMediaPlayer?.stop()
                        releaseMp()
                        createMP(audioFiles[lastPosition])
                        mMediaPlayer?.start()
                    } else {
                        Toast.makeText(context, "Это последняя песня", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> true
            }
        }
    }
}








