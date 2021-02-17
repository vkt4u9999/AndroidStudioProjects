package com.vkt4u9999.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.vkt4u9999.telegramclone.MainActivity
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.activities.RegisterActivity
import com.vkt4u9999.telegramclone.utilits.AUTH
import com.vkt4u9999.telegramclone.utilits.AppTextWatcher
import com.vkt4u9999.telegramclone.utilits.replaceActivity
import com.vkt4u9999.telegramclone.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment( val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title= phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher{
                    val string = register_input_code.text.toString()
                if (string.length>=6){
                    enterCode()
                    }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential=PhoneAuthProvider.getCredential(id,code)
        AUTH.signInWithCredential(credential).addOnCompleteListener() {
            if (it.isSuccessful) {
                showToast("Добро пожаловать!")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else {
                showToast(it.exception?.message.toString())
            }
        }
    }

    }
