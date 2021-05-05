package com.vkt4u9999.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.vkt4u9999.myapp.databinding.ActivityMainBinding
import com.vkt4u9999.myapp.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding


    private lateinit var test1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = inflate(layoutInflater)
        setContentView(mBinding.root)


        val items = listOf("apple, banana, orange")
       //mutableListOf("apple, banana, orange")

        for (item in items){
            println(item)
        }


        //while
        var index= 0
        while (index< items.size){
            println("Item at $index is ${items[index]}")
            index++
        }


    }
}
