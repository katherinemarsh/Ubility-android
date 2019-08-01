package com.android.ubility_android

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.reviews_list_page.*


class ReviewListFragment : Fragment() {

    private lateinit var viewModel: ReviewListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reviews_list_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewListViewModel::class.java)

        val myAdapter = ReviewItemAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.adapter = myAdapter

//        if (!viewModel.hasReviews) {
//            no_reviews.visibility = ViewGroup.VISIBLE
//        }

        viewModel.getReviews().observe(this, Observer {
            if (it != null) {
                myAdapter.list.clear()
                myAdapter.list.addAll(it.map {it.description.toString()})
                myAdapter.notifyDataSetChanged()
            }
        })
    }

}