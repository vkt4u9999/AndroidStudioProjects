package com.vkt4u9999.retrofitex2.Interface

import com.vkt4u9999.retrofitex2.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("marvel")

    fun getMovieList(): Call<MutableList<Movie>>

}