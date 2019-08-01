package com.android.ubility_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.android.ubility_android.data.Review
import com.android.ubility_android.data.db

class ReviewListViewModel : ViewModel() {
    var hasReviews: Boolean = false
    private var reviews: LiveData<List<Review>>? = null

    fun getReviews(): LiveData<List<Review>> {
        if (reviews == null) {
            reviews = db.reviewDao().getAll()
        }
        return reviews!!
    }

    init {
        var hasReviews = false
    }
}
