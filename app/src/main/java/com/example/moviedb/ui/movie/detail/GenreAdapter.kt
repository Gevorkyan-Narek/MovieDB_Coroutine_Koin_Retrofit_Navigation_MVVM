package com.example.moviedb.ui.movie.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.databinding.ItemGenreBinding

class GenreAdapter(
    private val genres: List<String>
) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    class GenreViewHolder(binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(
            ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.title.setText(genres[position].replaceFirstChar { it.uppercase() })
    }

    override fun getItemCount(): Int = genres.size
}