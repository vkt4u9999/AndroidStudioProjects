package com.vkt4u9999.telegramclone.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.vkt4u9999.telegramclone.models.User

lateinit var AUTH: FirebaseAuth
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var USER:User
lateinit var UID:String

const val NODE_USERS= "users"
const val NODE_USERNAMES = "usernames"

const val CHILD_ID= "id"
const val CHILD_PHONE= "phone"
const val CHILD_USERNAME= "username"
const val CHILD_FULLNAME= "fullname"
const val CHILD_BIO= "bio"


fun initFirebase(){
    AUTH= FirebaseAuth.getInstance()
    REF_DATABASE_ROOT= FirebaseDatabase.getInstance().reference
    USER= User()
    UID= AUTH.currentUser?.uid.toString()
}



