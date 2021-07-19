package com.vkt4u9999.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast: MutableLiveData<List<DailyForecast>> = MutableLiveData()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(city: String) {
        val randomValues = List(15) { Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map { temp ->
            DailyForecast(temp, getTempDescription(temp))
        }

        _weeklyForecast.value = forecastItems
    }

    private fun getTempDescription(temp: Float): String {
        return if (temp < 75) "It's cold" else "It's Great"
    }
}