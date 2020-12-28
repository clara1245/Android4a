package com.example.android4a.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.adapters.MovieAdapter
import com.example.android4a.data.local.models.MovieLocal
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject

class HomeActivity: AppCompatActivity() {
    private val homeViewModel: HomeViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val movietest = MovieLocal(adult = true, backdropPath = "cc", genreIds = IntArray(1), id= 3,
            originalLanguage = "french", originalTitle = "ibsfdlk", overview = "aaaaaaa bbbbbbbbb cccccccc ddddd",
        popularity = 35.0, posterPath = "/fYtHxTxlhzD4QWfEbrC1rypysSD.jpg", releaseDate = "date", title = "titre du film",
        video = true, voteAverage = 3.0, voteCount = 5)
         //  val movieList : List<MovieLocal> = listOf(movietest)
        // val adapter = MovieAdapter(this, movieList)
        // rv_movies.adapter = adapter
        homeViewModel.topRatedResponseLiveData.observe( this, Observer { it ->
            when(it){
                is HomeSuccess -> {
                    Log.d("clara", it.movies.toString())
                    val adapter = MovieAdapter(this, it.movies)
                    rv_movies.adapter = adapter
                }

                HomeError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("API Error")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        rv_movies.layoutManager = LinearLayoutManager(this.applicationContext)
        rv_movies.setHasFixedSize(true)
        rv_movies.itemAnimator = DefaultItemAnimator()
        homeViewModel.getTopRatedResponse()
    }
}