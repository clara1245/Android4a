package com.example.android4a.api

import com.example.android4a.data.local.models.TopRatedResponseLocal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("movie/top_rated")
    fun getTopRated(@Query(RetrofitClient.API_KEY_PARAM) apiKey: String,
                    @Query(RetrofitClient.LANGUAGE_REQUEST_PARAM) language: String)
            : Call<TopRatedResponseLocal>
}