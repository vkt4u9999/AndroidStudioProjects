package com.vkt4u9999.fragmenttrainer.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vkt4u9999.fragmenttrainer.R

 fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.dataContainer, fragment).commit()
}

fun Fragment.replaceFragment(fragment: Fragment) {
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.dataContainer, fragment)?.commit()
}