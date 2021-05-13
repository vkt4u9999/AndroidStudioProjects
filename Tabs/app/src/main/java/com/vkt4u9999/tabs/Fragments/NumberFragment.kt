package com.vkt4u9999.tabs.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.tabs.Model.CategoryViewModel
import com.vkt4u9999.tabs.R
import com.vkt4u9999.tabs.Utils.RecyclerAdapter

const val ARG_OBJECT = "object"

class NumberFragment : Fragment(), RecyclerAdapter.OnItemClickListener{

    private lateinit var rv: RecyclerView
    private lateinit var adapter: RecyclerAdapter
    private val categoryViewModel by lazy { ViewModelProviders.of(this).get(CategoryViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_number, container, false)
        rv = view.findViewById(R.id.recyclerview)
        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(context)
        adapter= RecyclerAdapter(this)
        rv.adapter= adapter
        categoryViewModel.getListCategory().observe(viewLifecycleOwner, Observer { it?.let{
            adapter.refreshCategory(it)
        } })
        return view
    }


    override fun onItemClick(position: Int) {

    }

}


