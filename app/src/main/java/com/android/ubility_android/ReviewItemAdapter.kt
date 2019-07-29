package com.android.ubility_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewItemAdapter: RecyclerView.Adapter<ReviewItemAdapter.ViewHolder>() {
    val list = mutableListOf<String>()

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ReviewItemAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.note_row, p0, false)
        return ViewHolder(view)
    }



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textView)

        fun update(index: Int) {
            textView.text = list[index]
        }
    }

}