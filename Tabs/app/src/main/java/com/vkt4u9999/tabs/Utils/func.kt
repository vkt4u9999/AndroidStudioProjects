package com.vkt4u9999.tabs.Utils

import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.vkt4u9999.tabs.R

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}
fun ImageView.setImage(url: Int) {
        Picasso.get()
            .load(url)
            .into(this)
}

