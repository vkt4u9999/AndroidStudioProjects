package com.vkt4u9999.telegramclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.databinding.FragmentChatsBinding
import com.vkt4u9999.telegramclone.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    lateinit var mBinding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSettingsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

    }
}
