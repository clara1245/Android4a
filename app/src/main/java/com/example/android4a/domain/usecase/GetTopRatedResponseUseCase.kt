package com.example.android4a.domain.usecase

import com.example.android4a.api.RetrofitClient
import com.example.android4a.data.local.models.TopRatedResponseLocal
import retrofit2.Call

class GetTopRatedResponseUseCase() {
    fun invoke (): Call<TopRatedResponseLocal>? {
       val tmdbApi = RetrofitClient.getClient(RetrofitClient.TMDB_URL)
        return tmdbApi?.getTopRated(RetrofitClient.API_KEY_VALUE, RetrofitClient.LANGUAGE)
    }
}