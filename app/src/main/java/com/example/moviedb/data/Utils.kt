package com.example.moviedb.data

import android.graphics.Rect
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

fun <T> Fragment.observe(liveData: LiveData<T>, observer: Observer<in T>) {
    liveData.observe(viewLifecycleOwner, observer)
}

fun <T> AppCompatActivity.observe(liveData: LiveData<T>, observer: Observer<in T>) {
    liveData.observe(this, observer)
}

fun TextView.clearText() {
    text = ""
}

fun RecyclerView.setItemDecorationMarginRight(margin: Int) {
    addItemDecoration(object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = margin
        }
    })
}