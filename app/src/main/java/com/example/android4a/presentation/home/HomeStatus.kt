package com.example.android4a.presentation.home

import com.example.android4a.data.local.models.MovieLocal

sealed class HomeStatus

data class HomeSuccess (val movies : List<MovieLocal>): HomeStatus()
object HomeError : HomeStatus()