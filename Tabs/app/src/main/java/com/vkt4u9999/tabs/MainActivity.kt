package com.vkt4u9999.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vkt4u9999.tabs.Utils.APP_ACTIVITY
import com.vkt4u9999.tabs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var mBinding: ActivityMainBinding
    private val tabNames: Array<String> = arrayOf(
        "Звуки",
        "Детские песни",
        "Избранное")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY= this
        adapter = MyPagerAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter





        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text= tabNames[position]
        }.attach()
    }

}