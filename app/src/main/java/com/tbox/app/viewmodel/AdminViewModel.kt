package com.tbox.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdminViewModel : ViewModel() {

    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val movieStorage = MovieStorage()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            _movieList.value = movieStorage.loadMovies()
        }
    }

    fun saveMovie(movie: Movie) {
        viewModelScope.launch {
            val updatedList = _movieList.value.toMutableList()
            val index = updatedList.indexOfFirst { it.id == movie.id }

            if (index >= 0) {
                updatedList[index] = movie
            } else {
                updatedList.add(movie)
            }

            _movieList.value = updatedList
            movieStorage.saveMovies(updatedList)
        }
    }

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            val updatedList = _movieList.value.toMutableList()
            updatedList.remove(movie)
            _movieList.value = updatedList
            movieStorage.saveMovies(updatedList)
        }
    }
}

