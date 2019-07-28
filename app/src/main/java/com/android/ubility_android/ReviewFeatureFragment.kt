package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.review_description_fragment.*


class ReviewFeatureFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewFeatureFragment()
    }

    private lateinit var viewModel: ReviewFeatureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.review_feature_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewFeatureViewModel::class.java)

        next_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_reviewFeatureFragment2_to_reviewPhotoFragment)
        }
    }

}
