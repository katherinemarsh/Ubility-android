package com.android.ubility_android.data


import android.app.Application
import androidx.room.Room

lateinit var db: AppDatabase

class App: Application() {
    override fun onCreate() {
        // doing this before on create so that we have access to the database anywhere within the app
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "AppDatabase").build()
        super.onCreate()
    }
}