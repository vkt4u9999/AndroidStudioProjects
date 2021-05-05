package com.vkt4u9999.fragmenttrainer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vkt4u9999.fragmenttrainer.R
import com.vkt4u9999.fragmenttrainer.databinding.FragmentABinding

import com.vkt4u9999.fragmenttrainer.utils.replaceFragment


class FragmentA : BaseChangeFragment(R.layout.fragment_a) {



    private var mBinding: FragmentABinding?= null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentABinding.inflate(inflater, container, false)




        binding.button.setOnClickListener {
            val text= binding.inputEditText.text.toString()


            replaceFragment(FragmentB())
        }

        return binding.root
    }

    override fun change() {
        val fragmentA= FragmentA()
        val text = binding.inputEditText.text.toString()
        fragmentA.arguments?.putString("text", text)

        if (text.isEmpty()) {
            Toast.makeText(activity, "Впишите данные", Toast.LENGTH_LONG).show()
        } else {
            replaceFragment(FragmentB())

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}