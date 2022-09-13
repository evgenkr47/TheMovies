package com.example.moviestest7.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestest7.REALIZATION
import com.example.moviestest7.models.MoviesItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragmentViewModel: ViewModel() {
    fun insert(moviesItemModel: MoviesItemModel, onSuccess:() -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovies(moviesItemModel){
                onSuccess()
            }
        }
    }

    fun delete(moviesItemModel: MoviesItemModel, onSuccess:() -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.deletetMovies(moviesItemModel){
                onSuccess()
            }
        }
    }
}