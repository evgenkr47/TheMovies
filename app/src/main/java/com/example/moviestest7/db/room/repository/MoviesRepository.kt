package com.example.moviestest7.db.room.repository

import androidx.lifecycle.LiveData
import com.example.moviestest7.models.MoviesItemModel

interface MoviesRepository {
    val allMovies: LiveData<List<MoviesItemModel>>
    suspend fun insertMovies(moviesItemModel: MoviesItemModel, onSuccess:() -> Unit)
    suspend fun deletetMovies(moviesItemModel: MoviesItemModel, onSuccess:() -> Unit)
}