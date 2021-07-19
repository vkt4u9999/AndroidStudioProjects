package com.vkt4u9999.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vkt4u9999.weatherapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val forecastRepository = ForecastRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


            val forecastList= mBinding.forecastList
            forecastList.layoutManager= LinearLayoutManager(applicationContext)
            val dailyForecastAdapter = DailyForecastAdapter(){
                Toast.makeText(applicationContext,getString(R.string.forecast_clicked_format,it.temp, it.description), Toast.LENGTH_SHORT).show()
            }
            forecastList.adapter= dailyForecastAdapter

            mBinding.button.setOnClickListener {
                val city: String= mBinding.editText.text.toString()
                if(city.length >= 2)
                    forecastRepository.loadForecast(city)
            }




        val weeklyForecastObserver = Observer<List<DailyForecast>>{forecastItems ->
            //update our list adapter
            dailyForecastAdapter.submitList(forecastItems)
        }
        forecastRepository.weeklyForecast.observe(this, weeklyForecastObserver)


    }
}