package com.android.ubility_android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.android.ubility_android.data.Review

class ReviewListViewModel : ViewModel() {
    var reviews = MutableLiveData<List<Review>>()
    var hasReviews: Boolean = false

    init {
        var hasReviews = false
    }
}