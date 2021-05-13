package com.vkt4u9999.cardsandmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vkt4u9999.cardsandmusic.Fragments.HomePetsFragment
import com.vkt4u9999.cardsandmusic.utilits.replaceFragment

class ActivityForCarousel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_carousel)

        replaceFragment(HomePetsFragment())

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}