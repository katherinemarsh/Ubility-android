package com.android.ubility_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class AutocompleteViewModel : ViewModel(), PlaceSelectionListener {

    var navigator: AutocompleteNavigator? = null
    // The current score
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    init {
        _name.value = ""
    }

    override fun onError(p0: Status) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPlaceSelected(p0: Place) {
        navigator?.navigateToPlace()
        _name.value = p0.name
    }
}
