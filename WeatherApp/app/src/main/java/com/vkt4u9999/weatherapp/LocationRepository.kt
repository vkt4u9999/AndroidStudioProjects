package com.vkt4u9999.weatherapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


sealed class Location {
    data class City(val city: String) : Location()
}

private const val KEY_CITY = "key_city"

class LocationRepository(context: Context) {

    private val preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    private val _savedLocation: MutableLiveData<Location> = MutableLiveData()
    val savedLocation: LiveData<Location> = _savedLocation


    init {
        preferences.registerOnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key != KEY_CITY) return@registerOnSharedPreferenceChangeListener

            broadcastSavedCity()
        }
        broadcastSavedCity()
    }

    fun saveLocation(location: Location) {
        when (location) {
            is Location.City -> preferences.edit().putString(KEY_CITY, location.city).apply()
        }
    }
    private fun broadcastSavedCity(){
        val city = preferences.getString(KEY_CITY, "")
        if (city != null && city.isNotBlank()) {
            _savedLocation.value = Location.City(city)
        }
    }
}