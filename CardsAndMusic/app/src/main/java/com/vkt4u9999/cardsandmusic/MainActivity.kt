package com.vkt4u9999.cardsandmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.size
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.cardsandmusic.Fragments.HomePetsFragment
import com.vkt4u9999.cardsandmusic.Model.CategoryViewModel
import com.vkt4u9999.cardsandmusic.databinding.ActivityMainBinding
import com.vkt4u9999.cardsandmusic.utilits.APP_ACTIVITY
import com.vkt4u9999.cardsandmusic.utilits.replaceActivity
import com.vkt4u9999.cardsandmusic.utilits.replaceFragment
import com.vkt4u9999.cardsandmusic.utilits.showToast

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var rv: RecyclerView
    private val categoryViewModel by lazy { ViewModelProviders.of(this).get(CategoryViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        rv= mBinding.dataContainer
        val adapter= RecyclerAdapter(this)

        rv.layoutManager= LinearLayoutManager(this)
        rv.adapter= adapter

        categoryViewModel.getListCategory().observe(this, Observer { it?.let{
            adapter.refreshCategory(it)
        } })
        mToolbar = mBinding.mainToolbar
        setSupportActionBar(mToolbar)
        mBinding.bottomNavigationView.setTextVisibility(false)
            .enableAnimation(false)

        for (i in 0 until mBinding.bottomNavigationView.size) {
            mBinding.bottomNavigationView.setIconTintList(i, null)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings_menu_more, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onItemClick(position: Int) {
        when(position){
            0 -> replaceActivity(ActivityForCarousel())
        }
    }
}

