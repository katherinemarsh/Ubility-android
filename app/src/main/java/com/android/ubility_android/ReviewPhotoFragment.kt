package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.review_photo_fragment.*


class ReviewPhotoFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewPhotoFragment()
    }

    private lateinit var viewModel: ReviewPhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.review_photo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewPhotoViewModel::class.java)

        submit_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_reviewPhotoFragment_to_placeFragment)
        }
    }

}
