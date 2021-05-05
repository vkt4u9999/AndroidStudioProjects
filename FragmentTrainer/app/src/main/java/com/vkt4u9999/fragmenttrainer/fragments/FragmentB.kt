package com.vkt4u9999.fragmenttrainer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vkt4u9999.fragmenttrainer.R
import com.vkt4u9999.fragmenttrainer.databinding.FragmentBBinding


class FragmentB : BaseChangeFragment(R.layout.fragment_b) {

    private var mBinding: FragmentBBinding? = null
    private val binding get() = mBinding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentBBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text= arguments?.getString("MyArg")
        binding.textView.text= text
    }

    override fun change() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}