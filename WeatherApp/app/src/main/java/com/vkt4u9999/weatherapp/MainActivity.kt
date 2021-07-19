package com.vkt4u9999.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vkt4u9999.weatherapp.databinding.ActivityMainBinding
import com.vkt4u9999.weatherapp.details.ForecastDetailsActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val forecastRepository = ForecastRepository()
    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        tempDisplaySettingManager = TempDisplaySettingManager(this)

        val forecastList = mBinding.forecastList
        forecastList.layoutManager = LinearLayoutManager(this)

        val dailyForecastAdapter = DailyForecastAdapter(tempDisplaySettingManager){
            showForecastDetails(it)
        }
        forecastList.adapter = dailyForecastAdapter

        mBinding.button.setOnClickListener {
            val city: String = mBinding.editText.text.toString()
            if (city.length >= 2)
                forecastRepository.loadForecast(city)
        }

        val weeklyForecastObserver = Observer<List<DailyForecast>> { forecastItems ->
            //update our list adapter
            dailyForecastAdapter.submitList(forecastItems)
        }
        forecastRepository.weeklyForecast.observe(this, weeklyForecastObserver)
    }

    private fun showForecastDetails(forecast: DailyForecast) {

        val forecastDetailsIntent = Intent(this, ForecastDetailsActivity::class.java)
        forecastDetailsIntent.putExtra("key_temp", forecast.temp)
        forecastDetailsIntent.putExtra("key_description", forecast.description)
        startActivity(forecastDetailsIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.tempDisplaySettings -> {
                showTempDisplaySettingDialog(this, tempDisplaySettingManager)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}