package com.vkt4u9999.retrofit2example.Interface

import com.vkt4u9999.retrofit2example.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET ("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}