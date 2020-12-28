package com.example.android4a.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.usecase.GetTopRatedResponseUseCase
import kotlinx.coroutines.*

class HomeViewModel (
    private val getTopRatedResponseUseCase: GetTopRatedResponseUseCase
) : ViewModel() {
    val topRatedResponseLiveData: MutableLiveData<HomeStatus> = MutableLiveData()
    fun getTopRatedResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            var homeStatus : HomeStatus? = null

            coroutineScope {
                val topRatedResponse = getTopRatedResponseUseCase.invoke()?.execute()
                if (topRatedResponse!= null) {
                    val response = topRatedResponse.body()
                    if (response!= null) {
                        val allMovieLocal = response.results
                        homeStatus = HomeSuccess(allMovieLocal)
                        Log.d("clara", homeStatus.toString())
                    }
                }

            }
            Log.d("clara", homeStatus.toString())
            withContext(Dispatchers.Main) {
                Log.d("clara","inwithcontext")
                topRatedResponseLiveData.value = homeStatus

            }
        }
    }

}