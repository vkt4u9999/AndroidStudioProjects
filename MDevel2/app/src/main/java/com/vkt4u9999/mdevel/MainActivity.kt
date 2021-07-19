package com.vkt4u9999.mdevel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
//        val weatherStation= WeatherStation()
//        weatherStation.addMan(Man("Aleksandra"))
//        weatherStation.addMan(Man("Igor"))
//        weatherStation.addMan(Man("Dima"))
//        weatherStation.updateWeather()

        val configuration= ConfigurationBuilder()
            .color(2)
            .latency(1000)
            .build()

        Log.d("TAG", configuration.toString())
    }
}