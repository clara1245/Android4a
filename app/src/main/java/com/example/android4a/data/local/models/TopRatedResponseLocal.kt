package com.example.android4a.data.local.models

import com.example.android4a.domain.entity.TopRatedResponse
import com.google.gson.annotations.SerializedName

data class TopRatedResponseLocal (
    @SerializedName("page")
    val page : Int,
    @SerializedName("results")
    val results : List<MovieLocal>,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
fun TopRatedResponse.toData() : TopRatedResponseLocal {
    return TopRatedResponseLocal(page, results, totalResults, totalPages)
}

fun TopRatedResponseLocal.toEntity() : TopRatedResponse {
    return TopRatedResponse(page, results, totalResults, totalPages)
}