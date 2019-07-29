package com.android.ubility_android.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Review::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun reviewDao(): ReviewDao
}