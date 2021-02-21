package com.vkt4u9999.telegramclone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.vkt4u9999.telegramclone.MainActivity
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.activities.RegisterActivity
import com.vkt4u9999.telegramclone.utilits.AUTH
import com.vkt4u9999.telegramclone.utilits.USER
import com.vkt4u9999.telegramclone.utilits.replaceActivity
import com.vkt4u9999.telegramclone.utilits.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings_menu_exit ->{
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()

    }

    private fun initFields() {
        settings_bio.text= USER.bio
        settings_full_name.text= USER.fullname
        settings_phone_number.text= USER.phone
        settings_status.text= USER.status
        settings_username.text= USER.username
    }
}
