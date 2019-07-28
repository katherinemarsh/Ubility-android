package com.android.ubility_android.data

data class Review(var author: String,
                  var description: String?,
                  var selectedFeatures: List<String>?,
                  var placeId: Place)