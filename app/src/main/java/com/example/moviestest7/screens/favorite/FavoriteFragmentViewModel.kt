package com.example.moviestest7.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestest7.REALIZATION
import com.example.moviestest7.models.MoviesItemModel
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel: ViewModel() {
    fun getAllMovies(): LiveData<List<MoviesItemModel>> {

           return REALIZATION.allMovies

    }
}