package com.example.moviestest7.db.room.repository

import androidx.lifecycle.LiveData
import com.example.moviestest7.db.room.dao.MoviesDao
import com.example.moviestest7.models.MoviesItemModel

class MoviesRepositoryRealization(private val moviesDao: MoviesDao): MoviesRepository {
    override val allMovies: LiveData<List<MoviesItemModel>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovies(moviesItemModel: MoviesItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(moviesItemModel)
    }

    override suspend fun deletetMovies(moviesItemModel: MoviesItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(moviesItemModel)
    }
}