package com.vkt4u9999.fragmenttrainer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.vkt4u9999.fragmenttrainer.databinding.ActivityMainBinding
import com.vkt4u9999.fragmenttrainer.fragments.FragmentA
import com.vkt4u9999.fragmenttrainer.fragments.FragmentB
import com.vkt4u9999.fragmenttrainer.utils.replaceFragment

class MainActivity : AppCompatActivity(){

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        replaceFragment(FragmentA())




    }

}

