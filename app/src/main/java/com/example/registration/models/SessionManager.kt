package com.example.registration.models

import android.content.Context
import android.content.SharedPreferences
import android.media.session.MediaSession
import androidx.core.R

class SessionManager(context:Context) {
    var sharedPreferences:SharedPreferences=context.getSharedPreferences("CODE_HIVE",Context.MODE_PRIVATE)

    fun saveAccToken(token:String){
        sharedPreferences.edit().putString("ACCESS_TOKEN",token).apply()

    }
    fun fetchAccToken():String?{
        return sharedPreferences.getString("ACCESS_TOKEN","")
    }
}

//class SessionManager(context: Context) {
//    var sharedPreferences: SharedPreferences = context.getSharedPreferences("HELLO_WORLD_2",Context.MODE_PRIVATE)
//    //function to save the accesstoken
//    fun saveAccToken(token:String){
//        sharedPreferences.edit().putString("ACCESS_TOKEN",token).apply()
//    }
//    //function to get the accesstoken
//    fun fetchAccToken():String?{
//        return sharedPreferences.getString("ACCESS_TOKEN","")
//    }