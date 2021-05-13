package com.vkt4u9999.cardsandmusic.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vkt4u9999.cardsandmusic.R
import com.vkt4u9999.cardsandmusic.RecyclerAdapter
import com.vkt4u9999.cardsandmusic.databinding.FragmentHomePetsBinding
import com.vkt4u9999.cardsandmusic.utilits.APP_ACTIVITY

class HomePetsFragment : Fragment(R.layout.fragment_home_pets), RecyclerAdapter.OnItemClickListener {

    private var _binding: FragmentHomePetsBinding? = null
    private val binding get() = _binding!!

    private lateinit var rv: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding =
           FragmentHomePetsBinding.inflate(inflater,container, false)
        rv= binding.dataContainer
        val adapter= RecyclerAdapter(this)
        rv.adapter=adapter

        val view= binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {

    }
}








