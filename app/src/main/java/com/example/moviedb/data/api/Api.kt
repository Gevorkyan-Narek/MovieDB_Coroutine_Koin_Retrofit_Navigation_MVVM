package com.example.moviedb.data.api

import android.widget.ImageView
import com.bumptech.glide.Glide

const val BASE_API_KEY = "7a00b045a944e9396f766b8e2b906775"

fun ImageView.setImage(
    url: String
) {
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/w500$url")
        .into(this)
}