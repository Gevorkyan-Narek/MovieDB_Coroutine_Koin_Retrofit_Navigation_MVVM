package com.example.moviedb.ui.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviedb.data.entity.movie.Movie
import com.example.moviedb.databinding.ItemFilmBinding

class MovieAdapter(
    private val movieList: List<Movie>,
    private val onClick: (Long) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        val poster = binding.poster
        val rate = binding.rate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val url = "https://image.tmdb.org/t/p/w500${movieList[position].posterPath}"
        holder.poster.load(url)
        holder.rate.text = movieList[position].voteAverage.toString()
        holder.itemView.setOnClickListener { onClick(movieList[position].id) }
        Log.i(
            this::class.simpleName,
            "Position: $position, posterUrl: $url, rate: ${holder.rate.text}"
        )
    }

    override fun getItemCount(): Int = movieList.size
}