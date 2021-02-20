package com.vkt4u9999.telegramclone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.databinding.ActivityRegisterBinding
import com.vkt4u9999.telegramclone.ui.fragments.EnterPhoneNumberFragment
import com.vkt4u9999.telegramclone.utilits.initFirebase
import com.vkt4u9999.telegramclone.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar=mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title=getString(R.string.title_your_phone)
        replaceFragment(EnterPhoneNumberFragment())

    }
}