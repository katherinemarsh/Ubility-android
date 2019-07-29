package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.libraries.places.api.net.FetchPhotoResponse
import kotlinx.android.synthetic.main.review_description_fragment.*
import kotlinx.android.synthetic.main.review_description_fragment.next_button
import kotlinx.android.synthetic.main.review_feature_fragment.*


class ReviewFeatureFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewFeatureFragment()
    }

    var clickListener: View.OnClickListener = View.OnClickListener {
        it.setBackgroundResource(R.drawable.round_peach_button)
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

        elevator_button.setOnClickListener(clickListener)
        helpful_staff_button.setOnClickListener(clickListener)
        interpretor_button.setOnClickListener(clickListener)
    }

}
