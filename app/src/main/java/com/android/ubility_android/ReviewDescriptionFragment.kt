package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.place_fragment.*
import kotlinx.android.synthetic.main.review_description_fragment.*


class ReviewDescriptionFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewDescriptionFragment()
    }

    private lateinit var viewModel: ReviewDescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.review_description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewDescriptionViewModel::class.java)

        next_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_reviewDescriptionFragment2_to_reviewFeatureFragment2)
        }
    }

}
