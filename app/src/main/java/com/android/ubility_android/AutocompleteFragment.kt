package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.libraries.places.api.model.Place
import java.util.*
import com.google.android.libraries.places.widget.AutocompleteSupportFragment as AutocompleteSupportFragment


class AutocompleteFragment : Fragment(), AutocompleteNavigator {

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

        val libraryAutocompleteFrag= this.childFragmentManager.findFragmentById(R.id.lib_autocomplete_fragment) as AutocompleteSupportFragment

        // setting up the type of data we want to return
        libraryAutocompleteFrag.apply {
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
        libraryAutocompleteFrag.setOnPlaceSelectedListener(viewModel)

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
