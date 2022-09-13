package com.example.moviestest7.db.retrofit.repository

import com.example.moviestest7.db.retrofit.api.RetrofitInstance
import com.example.moviestest7.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovie(): Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}