package com.vkt4u9999.tabs

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vkt4u9999.tabs.Fragments.*


class MyPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int= 3




    override fun createFragment(position: Int): Fragment {
        val fragment: List<Fragment> = listOf(CategoryFragment(),SongsFragment(), FavoriteFragment())
        when(position){
            0 -> fragment[0]
            1 -> fragment[1]
            else -> fragment[2]
        }
        return fragment[position]
    }


}


