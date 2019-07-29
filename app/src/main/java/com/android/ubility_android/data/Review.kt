package com.android.ubility_android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Review(
    @PrimaryKey(autoGenerate = true)
    var author: String,
    var description: String?,
    var selectedFeatures: List<String>?,
    var placeId: Place
)