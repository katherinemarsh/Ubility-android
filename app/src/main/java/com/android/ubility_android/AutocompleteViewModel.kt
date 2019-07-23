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



class AutocompleteViewModel : ViewModel(), PlaceSelectionListener {

    var navigator: AutocompleteNavigator? = null
    // The current score
//    private val _name = MutableLiveData<String>()
//    val name: LiveData<String>
//        get() = _name

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
        navigator?.navigateToPlace()
        var editPlace = com.android.ubility_android.data.Place(p0.name, p0.address)
        _myPlace.value = editPlace
    }

//    private fun getPlacePhoto(pm: PhotoMetadata): Bitmap {
//        // Get the photo metadata.
//        val photoMetadata = pm
//
//        // Get the attribution text.
//        val attributions = photoMetadata.attributions
//
//        // Create a FetchPhotoRequest.
//        val photoRequest = FetchPhotoRequest.builder(photoMetadata)
//            .setMaxWidth(500) // Optional.
//            .setMaxHeight(300) // Optional.
//            .build()
//        placesClient.fetchPhoto(photoRequest).addOnSuccessListener({ fetchPhotoResponse: FetchPhotoRequest ->
//            val bitmap = fetchPhotoResponse.getBitmap()
////            imageView.setImageBitmap(bitmap)
//        }).addOnFailureListener({ exception ->
//            //do stuff
//        })
//        return null
//    }
}
