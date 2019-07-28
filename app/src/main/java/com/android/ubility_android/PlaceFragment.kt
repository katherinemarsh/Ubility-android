package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.ubility_android.databinding.PlaceFragmentBinding
import kotlinx.android.synthetic.main.place_fragment.*

class PlaceFragment : Fragment() {

    private lateinit var binding: PlaceFragmentBinding

    private lateinit var viewModel: AutocompleteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.place_fragment,
            container,
            false
        )

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AutocompleteViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the VieWModel
        binding.autocompleteViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        add_review_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_placeFragment_to_reviewDescriptionFragment2)
        }
    }
}
