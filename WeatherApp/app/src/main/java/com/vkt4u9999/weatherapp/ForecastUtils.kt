package com.vkt4u9999.weatherapp

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun formatTempForDisplay(temp: Float, tempDisplaySetting: TempDisplaySetting): String {
    return when (tempDisplaySetting) {
        TempDisplaySetting.Fahrenheit -> String.format("%.2f°", temp)
        TempDisplaySetting.Celsius -> {
            val temp = (temp - 32f) * (5f / 9f)
            String.format("%.2f C°", temp)
        }
    }
}


fun showTempDisplaySettingDialog(
    context: Context,
    tempDisplaySettingManager: TempDisplaySettingManager
) {
    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Выберите отображаемые единицы измерения")
        .setMessage("Выберите какие единицы измерения использовать для отображения температуры")
        .setPositiveButton("F°") { _, _ ->
            tempDisplaySettingManager.updateSetting(TempDisplaySetting.Fahrenheit)

        }
        .setNegativeButton("C°") { _, _ ->
            tempDisplaySettingManager.updateSetting((TempDisplaySetting.Celsius))

        }
        .setOnDismissListener {
            Toast.makeText(
                context,
                "Изменения вступят в силу после перезапуска проложения",
                Toast.LENGTH_SHORT
            ).show()
        }

    dialogBuilder.show()
}

