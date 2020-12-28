package com.example.android4a.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.api.RetrofitClient
import com.example.android4a.data.local.models.MovieLocal
import com.squareup.picasso.Picasso


class MovieAdapter(
    private var context: Context,
    private var movies: List<MovieLocal>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie : MovieLocal = movies[position]
        if (movie != null) holder.bindTo(movie)
    }

    class MovieViewHolder(inflater:LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.movie_item, parent, false)) {
        private var movieLayout : LinearLayout? = null
        private var moviePoster : ImageView?= null
        private var movieTitle : TextView?= null
        private var movieOverview : TextView?= null

        init {
            this.movieLayout = itemView.findViewById(R.id.list_item_movie)
            this.moviePoster = itemView.findViewById(R.id.item_movie_poster)
            this.movieTitle = itemView.findViewById(R.id.movie_title)
            this.movieOverview = itemView.findViewById(R.id.movie_overview)
        }

        fun bindTo(movie : MovieLocal) {
            val poster : String = RetrofitClient.getFullPosterPath(movie.posterPath)
            Picasso.get().load(poster).into(this.moviePoster)
            val title : String = movie.title
            this.movieTitle?.text = title
            val overview : String = movie.overview
            this.movieOverview?.text = overview

        }
    }


}