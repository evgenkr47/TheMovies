package com.example.moviestest7.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class MoviesItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val overview: String,

    @ColumnInfo
    val poster_path: String,

    @ColumnInfo
    val release_date: String,

    @ColumnInfo
    val title: String

) : Serializable