package com.vkt4u9999.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vkt4u9999.weatherapp.databinding.ActivityMainBinding
import com.vkt4u9999.weatherapp.details.ForecastDetailsActivity
import com.vkt4u9999.weatherapp.forecast.CurrentForecastFragment
import com.vkt4u9999.weatherapp.location.LocationEntryFragment
import java.util.*

class MainActivity : AppCompatActivity(), AppNavigator {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        tempDisplaySettingManager = TempDisplaySettingManager(this)



        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, LocationEntryFragment())
            .commit()
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

    override fun navigateToCurrentForecast(city: String) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, CurrentForecastFragment.newInstance(city))
            .commit()
    }

    override fun navigateToLocationEntry() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LocationEntryFragment())
            .commit()
    }


}