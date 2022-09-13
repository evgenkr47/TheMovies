package com.example.moviestest7.db.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviestest7.db.room.dao.MoviesDao
import com.example.moviestest7.models.MoviesItemModel


@Database(entities = [MoviesItemModel::class], version = 1)
abstract class MoviesRoomDataBase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao

    companion object{
        private var database: MoviesRoomDataBase ?= null

        @Synchronized
        fun getInstance(context: Context): MoviesRoomDataBase{

            return if (database == null){
                database = Room.databaseBuilder(context, MoviesRoomDataBase::class.java, "db").build()
                database as MoviesRoomDataBase
            }
            else{
                database as MoviesRoomDataBase
            }
        }
    }

}