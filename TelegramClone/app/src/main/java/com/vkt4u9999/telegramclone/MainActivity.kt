package com.vkt4u9999.telegramclone

import android.content.Context
import android.content.Intent
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import com.theartofdev.edmodo.cropper.CropImage
import com.vkt4u9999.telegramclone.activities.RegisterActivity
import com.vkt4u9999.telegramclone.databinding.ActivityMainBinding
import com.vkt4u9999.telegramclone.models.User
import com.vkt4u9999.telegramclone.ui.fragments.ChatsFragment
import com.vkt4u9999.telegramclone.ui.objects.AppDrawer
import com.vkt4u9999.telegramclone.utilits.*


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    lateinit var mAppDrawer: AppDrawer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY= this
        initFields()
        initFunc()
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        initFirebase()
        initUser()
    }

    //Подключаемся к базе и обновляем user при запуске приложения
    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).addListenerForSingleValueEvent(AppValueEventListener{

            USER=it.getValue(User::class.java) ?: User()
    })
    }

    private fun initFunc() {
        if (AUTH.currentUser!=null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }
}