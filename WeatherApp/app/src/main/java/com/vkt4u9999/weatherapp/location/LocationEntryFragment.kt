package com.vkt4u9999.weatherapp.location

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.vkt4u9999.weatherapp.AppNavigator
import com.vkt4u9999.weatherapp.ForecastRepository
import com.vkt4u9999.weatherapp.R
import com.vkt4u9999.weatherapp.R.id.button
import com.vkt4u9999.weatherapp.TempDisplaySettingManager

class LocationEntryFragment : Fragment() {

    private lateinit var appNavigator: AppNavigator


    override fun onAttach(context: Context) {
        super.onAttach(context)
        appNavigator= context as AppNavigator
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_location_entry, container, false)

        val cityEditText: EditText= view.findViewById(R.id.editText)
        val enterButton: Button = view.findViewById(button)

        enterButton.setOnClickListener {
            val city= cityEditText.text.toString()

            if (city.length <2){
                Toast.makeText(context, "Не верное название города", Toast.LENGTH_SHORT).show()
            }else{
                appNavigator.navigateToCurrentForecast(city)
            }
        }
        return view
    }

}