package com.example.android4a.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient{
    companion object {
        const val TMDB_URL : String = "https://api.themoviedb.org/3/"
        const val TMDB_IMAGE_URL : String = "https://image.tmdb.org/t/p/w300/"
        const val API_KEY_PARAM : String = "api_key"
        const val API_KEY_VALUE: String = "58fe982d8c27ead27ff36f8fe7615a2d"
        const val LANGUAGE_REQUEST_PARAM : String = "language"
        const val LANGUAGE : String = "fr"

        fun getClient(URL: String) : TMDBApi? {
            val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client : OkHttpClient = OkHttpClient.Builder()
                                                    .addInterceptor(interceptor)
                                                    .connectTimeout(10,TimeUnit.SECONDS)
                                                    .readTimeout(10,TimeUnit.SECONDS)
                                                    .build()
            val builder : Retrofit.Builder = Retrofit.Builder ()
                                                     .addConverterFactory(GsonConverterFactory.create())
                                                     .client(client)
                                                     .baseUrl(URL)
            return builder.build().create(TMDBApi::class.java)
        }

        fun getFullPosterPath(path: String) : String {
            return if(path!=null) TMDB_IMAGE_URL + path else ""
        }
    }
}