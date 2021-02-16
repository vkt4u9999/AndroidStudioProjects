package com.vkt4u9999.telegramclone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import com.vkt4u9999.telegramclone.R


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

    }
}
