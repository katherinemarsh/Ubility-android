package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.android.ubility_android.data.Review
import com.android.ubility_android.data.db
import kotlinx.android.synthetic.main.place_fragment.*
import kotlinx.android.synthetic.main.review_description_fragment.*
import kotlin.concurrent.thread


class ReviewDescriptionFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewDescriptionFragment()
    }

    private lateinit var viewModel: ReviewDescriptionViewModel

    val myAdapter = ReviewItemAdapter()
//    recyclerView.adapter = myAdapter

    val clickListener: View.OnClickListener = View.OnClickListener {
        //create a new instance of the Review
        //get the text from the edit text field
        //set the description of our new review as the text from the text field.
        val reviewDesc = review_description_edit.text.toString()
        thread {
            val review = Review(null, reviewDesc)
            db.reviewDao().insert(review)
        }
        review_description_edit.setText("")
        it.findNavController().navigate(R.id.action_reviewDescriptionFragment2_to_reviewFeatureFragment2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.review_description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewDescriptionViewModel::class.java)

        next_button.setOnClickListener(clickListener)
    }

}
