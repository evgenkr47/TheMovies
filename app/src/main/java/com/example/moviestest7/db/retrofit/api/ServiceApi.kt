package com.example.moviestest7.db.retrofit.api

import com.example.moviestest7.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("3/movie/popular?api_key=a5ba47a7ca3e23a9d83875a1a28d5448&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>
}