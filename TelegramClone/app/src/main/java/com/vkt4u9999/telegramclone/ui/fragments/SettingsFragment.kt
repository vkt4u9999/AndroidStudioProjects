package com.vkt4u9999.telegramclone.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import com.vkt4u9999.telegramclone.R
import com.vkt4u9999.telegramclone.activities.RegisterActivity
import com.vkt4u9999.telegramclone.utilits.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                APP_ACTIVITY.replaceActivity(RegisterActivity())
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
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_username.text = USER.username
        settings_user_photo.downloadAndSetImage(USER.photoUrl)
        settings_btn_change_username.setOnClickListener { replaceFragment(ChangeUsernameFragment()) }
        settings_btn_change_bio.setOnClickListener { replaceFragment(ChangeBioFragment()) }
        settings_change_photo.setOnClickListener { changePhotoUser() }
    }

    private fun changePhotoUser() {
        CropImage.activity()
            //Чтобы кропер был пропорционален, не растягивался
            .setAspectRatio(1, 1)
            //Обрезает до данного разрешения
            .setRequestedSize(600, 600)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(APP_ACTIVITY, this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            val uri= CropImage.getActivityResult(data).uri
            val path= REF_STORAGE_ROOT.child(FOLDER_PROFILE_IMAGE).child(CURRENT_UID)
            path.putFile(uri).addOnCompleteListener{task1 ->
                if (task1.isSuccessful){
                    path.downloadUrl.addOnCompleteListener {task2 ->
                        if (task2.isSuccessful){
                            val photoUrl= task2.result.toString()
                            REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(
                                CHILD_PHOTO_URL).setValue(photoUrl).addOnCompleteListener { task3 ->
                                if (task3.isSuccessful){
                                    settings_user_photo.downloadAndSetImage(photoUrl)
                                    showToast(getString(R.string.toast_data_update))
                                    USER.photoUrl= photoUrl
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
