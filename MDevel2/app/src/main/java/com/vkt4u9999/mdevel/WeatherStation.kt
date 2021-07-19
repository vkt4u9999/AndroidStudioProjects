package com.vkt4u9999.mdevel

import android.os.Handler
import java.util.*

class WeatherStation {

    var degrees = 0
    val people: MutableList<ManBehavior> = LinkedList()


    fun addMan(manBehavior: ManBehavior) {
        people.add(manBehavior)
    }

    fun updateWeather() {
        degrees = Random().nextInt(400)
        people.forEach {
            it.whatToWear(degrees = degrees)
        }
        val handler = Handler()
        handler.postDelayed({
            updateWeather()

        }, 200)
    }
}