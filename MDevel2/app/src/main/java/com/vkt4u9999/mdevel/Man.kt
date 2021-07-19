package com.vkt4u9999.mdevel

import android.util.Log

class Man(val name:String): ManBehavior {


    override fun whatToWear(degrees: Int) {
        if (degrees> 200){
            Log.d("TAG", "WARM"+ name)
        }else{
            Log.d("TAG", "Cold"+ name)
        }
    }
}