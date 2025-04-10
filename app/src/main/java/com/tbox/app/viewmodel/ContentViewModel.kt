package com.tbox.app.viewmodel

import androidx.lifecycle.ViewModel
import com.tbox.app.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContentViewModel : ViewModel() {

    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList = _movieList.asStateFlow()

    fun addDummyMovie() {
        val newMovie = Movie(
            id = System.currentTimeMillis().toString(),
            title = "סרט חדש",
            url = "https://example.com/movie"
        )
        _movieList.value = _movieList.value + newMovie
    }

    fun updateMovie(updated: Movie) {
        _movieList.value = _movieList.value.map {
            if (it.id == updated.id) updated else it
        }
    }

    fun deleteMovie(movie: Movie) {
        _movieList.value = _movieList.value.filterNot { it.id == movie.id }
    }
}
