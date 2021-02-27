package com.vkt4u9999.telegramclone.utilits

enum class AppStates(val state: String) {
    ONLINE("в сети"),
    OFFLINE("не в сети"),
    TYPING("печатает...");

    companion object{
        fun updateState(appStates: AppStates){
            REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_STATE)
                .setValue(appStates.state)
                .addOnSuccessListener { USER.state= appStates.state }
                .addOnFailureListener{showToast(it.message.toString())}
        }
    }


}