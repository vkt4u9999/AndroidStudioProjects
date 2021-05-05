package com.vkt4u9999.retrofit2example.Common

import com.vkt4u9999.retrofit2example.Interface.RetrofitServices
import com.vkt4u9999.retrofit2example.Retrofit.RetrofitClient

object Common {

    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}