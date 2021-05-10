package com.vkt4u9999.cardsandmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.cardsandmusic.Fragments.HomePetsFragment
import com.vkt4u9999.cardsandmusic.databinding.ActivityMainBinding
import com.vkt4u9999.cardsandmusic.utilits.APP_ACTIVITY
import com.vkt4u9999.cardsandmusic.utilits.replaceFragment
import com.vkt4u9999.cardsandmusic.utilits.showToast

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY= this
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mToolbar = mBinding.mainToolbar
        setSupportActionBar(mToolbar)
        mBinding.bottomNavigationView.setTextVisibility(false)
            .enableAnimation(false)

        for (i in 0 until mBinding.bottomNavigationView.size) {
            mBinding.bottomNavigationView.setIconTintList(i, null)
        }
        recyclerView= mBinding.recyclerView
        recyclerView.hasFixedSize()
        recyclerView.layoutManager= LinearLayoutManager(this)

        val categoryResource: MutableList<Int> = mutableListOf()
        categoryResource.add(R.drawable.home_pets)
        categoryResource.add(R.drawable.wild_animals)
        categoryResource.add(R.drawable.home_birds)
        categoryResource.add(R.drawable.wild_birds)
        categoryResource.add(R.drawable.insects)
        categoryResource.add(R.drawable.tech)
        categoryResource.add(R.drawable.cars)
        categoryResource.add(R.drawable.music_instruments)
        categoryResource.add(R.drawable.emotions)
        categoryResource.add(R.drawable.nature)
        categoryResource.add(R.drawable.songs)

        recyclerView.adapter=RecyclerAdapter(getCategoryNameList(),categoryResource,this)





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings_menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun getCategoryNameList():List<String>{
        return this.resources.getStringArray(R.array.categories).toList()
    }

    override fun onItemClick(position: Int) {
        when(position){
            0 -> replaceFragment(HomePetsFragment())
        }
    }
}