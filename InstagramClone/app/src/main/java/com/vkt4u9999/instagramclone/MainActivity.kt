package com.vkt4u9999.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableItemShiftingMode(false)
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)
        for (i in 0 until bottom_navigation_view.size){
            bottom_navigation_view.setIconTintList(i, null)
        }
    }
}