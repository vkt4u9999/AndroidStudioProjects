package com.vkt4u9999.retrofit2example

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vkt4u9999.retrofit2example.Adapter.MyMovieAdapter
import com.vkt4u9999.retrofit2example.Common.Common
import com.vkt4u9999.retrofit2example.Interface.RetrofitServices
import com.vkt4u9999.retrofit2example.Model.Movie
import com.vkt4u9999.retrofit2example.databinding.ActivityMainBinding


import dmax.dialog.SpotsDialog

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog

    lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mService = Common.retrofitServices
        mBinding.recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        mBinding.recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                mBinding.recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}