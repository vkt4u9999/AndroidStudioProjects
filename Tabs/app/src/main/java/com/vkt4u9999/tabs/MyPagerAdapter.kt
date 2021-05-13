package com.vkt4u9999.tabs

import android.os.Bundle
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vkt4u9999.tabs.Fragments.*


class MyPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int= 3

    override fun createFragment(position: Int): Fragment {
        val fragment= NumberFragment()
        fragment.arguments= Bundle().apply {
            putInt(ARG_OBJECT, position+1)
        }
        return fragment
    }


}


