package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.util.*
import com.google.android.libraries.places.internal.i


class AutocompleteFragment : AutocompleteSupportFragment(), AutocompleteNavigator {

    private lateinit var viewModel: AutocompleteViewModel

    override fun onCreateView(p0: LayoutInflater, p1: ViewGroup?, p2: Bundle?): View? {
        super.onCreateView(p0, p1, p2)
        val rootView = p0.inflate(R.layout.fragment_autocomplete, p1, false);
        return rootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AutocompleteViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

//        will allow navigation from within viewmodel
        viewModel.navigator = this

        // setting up the type of data we want to return
        this.apply {
            setPlaceFields(
                Arrays.asList(
                    Place.Field.NAME,
                    Place.Field.ADDRESS,
                    Place.Field.OPENING_HOURS,
                    Place.Field.PHOTO_METADATAS
                )
            )
        }

        // passing VM here, and making sure it implements PlaceSelectionListener
        this.setOnPlaceSelectedListener(viewModel)

//        // Set up a PlaceSelectionListener to handle the response.
//        This is how it would be done if we didn't have the viewmodel
//        this.setOnPlaceSelectedListener(object : PlaceSelectionListener {
//            override fun onPlaceSelected(p0: Place) {
//
//            }
//
//            override fun onError(p0: Status) {
//            }
//        })
    }

    override fun navigateToPlace() {
//        viewTransactionsButton.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.viewTransactionsAction)
//        }
        this.findNavController().navigate(R.id.action_autocompleteFragment_to_placeFragment)
    }
}
