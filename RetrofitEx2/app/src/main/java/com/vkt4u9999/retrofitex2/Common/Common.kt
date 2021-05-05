package com.vkt4u9999.retrofitex2.Common

import com.vkt4u9999.retrofitex2.Interface.RetrofitServices
import com.vkt4u9999.retrofitex2.Retrofit.RetrofitClient

object Common {

    private val BASE_URL = "/www.simplifiedcoding.net/demos/"

    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}