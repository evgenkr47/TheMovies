package com.example.moviestest7.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviestest7.REALIZATION
import com.example.moviestest7.db.retrofit.repository.RetrofitRepository
import com.example.moviestest7.db.room.MoviesRoomDataBase
import com.example.moviestest7.db.room.repository.MoviesRepositoryRealization
import com.example.moviestest7.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application
    fun getAllMovies(){
        viewModelScope.launch {
            myMovies.value = repository.getMovie()
        }
    }

    fun initDataBase(){
        val daoMovies = MoviesRoomDataBase.getInstance(context).getMoviesDao()
        REALIZATION = MoviesRepositoryRealization(daoMovies)
    }

}