package com.tboxe.viewmodel

import androidx.lifecycle.ViewModel
import com.tboxe.model.Movie
import com.tboxe.data.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieViewModel : ViewModel() {
    private val movieRepo = MovieRepository()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    init {
        loadMovies()
    }

    fun loadMovies() {
        _movies.value = movieRepo.getAllMovies()
    }

    fun addMovie(title: String, description: String, streamUrl: String): Boolean {
        if (title.isBlank() || streamUrl.isBlank()) return false
        val movie = Movie(title = title, description = description, streamUrl = streamUrl)
        val result = movieRepo.addMovie(movie)
        if (result) loadMovies()
        return result
    }

    fun deleteMovie(title: String): Boolean {
        val result = movieRepo.deleteMovie(title)
        if (result) loadMovies()
        return result
    }

    fun getMovie(title: String): Movie? {
        return movieRepo.getMovieByTitle(title)
    }
}
