package com.example.android4a.domain.entity

import com.example.android4a.data.local.models.MovieLocal

data class TopRatedResponse(
    val page : Int,
    val results : List<MovieLocal>,
    val totalResults : Int,
    val totalPages: Int
){
}