package com.vkt4u9999.telegramclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.databinding.FragmentChatsBinding


class ChatsFragment : Fragment() {

    lateinit var mBinding: FragmentChatsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

    }
}