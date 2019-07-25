package com.android.ubility_android

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.PhotoMetadata
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.libraries.places.internal.e
import com.google.android.gms.common.api.ApiException
import android.provider.MediaStore.Images.Media.getBitmap
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import android.R.attr.apiKey
import android.app.Application
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.BindingAdapter
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.libraries.places.api.net.FetchPhotoResponse


class AutocompleteViewModel(application: Application) : AndroidViewModel(application), PlaceSelectionListener {

    var navigator: AutocompleteNavigator? = null
    val successListener: OnSuccessListener<FetchPhotoResponse> = OnSuccessListener {
        val newPlace = _myPlace.value
        newPlace?.image = it.bitmap
        _myPlace.value = newPlace
    }

    private val _myPlace = MutableLiveData<com.android.ubility_android.data.Place>()
    val myPlace: LiveData<com.android.ubility_android.data.Place>
        get() = _myPlace

//    init {
//        _name.value = ""
//    }

    override fun onError(p0: Status) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPlaceSelected(p0: Place) {
        _myPlace.value = com.android.ubility_android.data.Place(p0.name, p0.address, null)
        getPlacePhoto(p0.photoMetadatas?.get(0))

        navigator?.navigateToPlace()
    }

    private fun getPlacePhoto(pm: PhotoMetadata?) {

        // Create a FetchPhotoRequest.
        val photoRequest = FetchPhotoRequest.builder(pm!!)
                .setMaxWidth(500) // Optional.
                .setMaxHeight(300) // Optional.
                .build()

        // Create a new Places client instance
        val placesClient = Places.createClient(getApplication())
        placesClient.fetchPhoto(photoRequest).addOnSuccessListener(successListener)
//        we receive the request, and then it goes to the on success listener
//        the problem with that is that the request can take a long time
//        most likely taking so long that the successListener instance (if created in here)
//        would no longer exist at the point once the bitmap is received from the places api
//        thus, we need to add the on success listener instance outside of this function
    }
}
