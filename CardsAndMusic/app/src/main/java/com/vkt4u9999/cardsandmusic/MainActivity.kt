package com.vkt4u9999.cardsandmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.cardsandmusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mToolbar = mBinding.mainToolbar
        setSupportActionBar(mToolbar)
        mBinding.bottomNavigationView.setTextVisibility(false)
            .enableAnimation(false)

        for (i in 0 until mBinding.bottomNavigationView.size) {
            mBinding.bottomNavigationView.setIconTintList(i, null)
        }

        val categoryImageResource: MutableList<Int> = mutableListOf()
        categoryImageResource.add(R.drawable.home_pets)
        categoryImageResource.add(R.drawable.wild_animals)
        categoryImageResource.add(R.drawable.home_birds)
        categoryImageResource.add(R.drawable.wild_birds)
        categoryImageResource.add(R.drawable.insects)
        categoryImageResource.add(R.drawable.tech)
        categoryImageResource.add(R.drawable.cars)
        categoryImageResource.add(R.drawable.music_instruments)
        categoryImageResource.add(R.drawable.emotions)
        categoryImageResource.add(R.drawable.nature)
        categoryImageResource.add(R.drawable.songs)
        recyclerView= mBinding.recyclerView
        recyclerView.hasFixedSize()
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=RecyclerAdapter(getCategoryNameList(),categoryImageResource)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings_menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun getCategoryNameList():List<String>{
        return this.resources.getStringArray(R.array.categories).toList()
    }

}