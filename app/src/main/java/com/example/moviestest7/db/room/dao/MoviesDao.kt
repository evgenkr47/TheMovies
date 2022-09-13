package com.example.moviestest7.db.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviestest7.models.MoviesItemModel


@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(moviesItemModel: MoviesItemModel)

    @Delete
    suspend fun delete(moviesItemModel: MoviesItemModel)

    @Query("SELECT * from movie_table")
    fun getAllMovies(): LiveData<List<MoviesItemModel>>

}