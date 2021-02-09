package com.vkt4u9999.kotlinapp

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTextView.text = "Hello Kotlin"


    }

    fun changeText(view: View) {
         helloTextView.text="Hey there!!!"
    }

}