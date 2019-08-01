package com.android.ubility_android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Review(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val description: String?
)