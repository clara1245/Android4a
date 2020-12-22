package com.example.android4a.data.local.models

import com.example.android4a.domain.entity.TopRatedResponse

data class TopRatedResponseLocal (
    val page : Int,
    val results : List<MovieLocal>,
    val totalResults : Int,
    val totalPages: Int
)
fun TopRatedResponse.toData() : TopRatedResponseLocal {
    return TopRatedResponseLocal(page, results, totalResults, totalPages)
}

fun TopRatedResponseLocal.toEntity() : TopRatedResponse {
    return TopRatedResponse(page, results, totalResults, totalPages)
}