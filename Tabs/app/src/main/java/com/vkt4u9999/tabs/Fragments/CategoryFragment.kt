package com.vkt4u9999.tabs.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.tabs.ImageSliderActivity
import com.vkt4u9999.tabs.MainActivity
import com.vkt4u9999.tabs.Model.CategoryViewModel
import com.vkt4u9999.tabs.R
import com.vkt4u9999.tabs.Utils.RecyclerCategoryAdapter


class CategoryFragment : Fragment(), RecyclerCategoryAdapter.OnItemClickListener{

    private lateinit var rv: RecyclerView
    private lateinit var adapter: RecyclerCategoryAdapter
    private val categoryViewModel by lazy { ViewModelProviders.of(this).get(CategoryViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_number, container, false)

        initFunc(view)
        return view
    }

    fun initFunc(view: View){
        rv = view.findViewById(R.id.recyclerview)
        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(context)
        adapter= RecyclerCategoryAdapter(this)
        rv.adapter= adapter
        categoryViewModel.getListCategory().observe(viewLifecycleOwner, Observer { it?.let{
            adapter.refreshCategory(it)
        } })
    }

    fun changeActivity(activity: AppCompatActivity){
        val intent = Intent(context, activity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(position: Int) {


        when (position){

            0 -> changeActivity(ImageSliderActivity())
        }
    }

}


