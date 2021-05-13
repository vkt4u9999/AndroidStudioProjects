package com.vkt4u9999.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vkt4u9999.tabs.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextLong


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var mBinding: ActivityMainBinding
    private val tabNames: Array<String> = arrayOf(
        "Категории",
        "Детские песни",
        "Избранное")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        adapter = MyPagerAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter





        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text= tabNames[position]
        }.attach()
    }


}