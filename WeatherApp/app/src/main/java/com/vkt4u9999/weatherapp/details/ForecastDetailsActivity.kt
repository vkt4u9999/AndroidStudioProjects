package com.vkt4u9999.weatherapp.details

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vkt4u9999.weatherapp.*
import com.vkt4u9999.weatherapp.databinding.ActivityForecastDetailsBinding

class ForecastDetailsActivity : AppCompatActivity() {

    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    private lateinit var mBinding: ActivityForecastDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding= ActivityForecastDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        tempDisplaySettingManager= TempDisplaySettingManager(this)
        val tempText= mBinding.tempText
        val tempDescriptionText= mBinding.tempDescriptionText
        val temp= intent.getFloatExtra("key_temp", 0f)



        tempText.text= formatTempForDisplay(temp, tempDisplaySettingManager.getTempDisplaySetting())
        tempDescriptionText.text= "${intent.getStringExtra("key_description")}"

        setTitle(R.string.forecast_details)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater= menuInflater
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