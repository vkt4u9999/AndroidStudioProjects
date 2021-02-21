package com.vkt4u9999.telegramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.vkt4u9999.telegramclone.activities.RegisterActivity
import com.vkt4u9999.telegramclone.databinding.ActivityMainBinding
import com.vkt4u9999.telegramclone.models.User
import com.vkt4u9999.telegramclone.ui.fragments.ChatsFragment
import com.vkt4u9999.telegramclone.ui.fragments.EnterPhoneNumberFragment
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

    }

    override fun onStart() {
        super.onStart()
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
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).addListenerForSingleValueEvent(AppValueEventListener{

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