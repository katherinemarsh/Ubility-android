package com.android.ubility_android.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReviewDao {
    @Query("select * from review")
    fun getAll(): LiveData<List<Review>>

    @Insert
    fun insert(review: Review)
}