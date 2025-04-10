package com.tbox.app.viewmodel

import androidx.lifecycle.ViewModel
import com.tbox.app.model.Movie
import com.tbox.app.repository.MovieRepository

class MovieViewModel : ViewModel() {
    private val repo = MovieRepository()

    fun getAllMovies(): List<Movie> = repo.getAllMovies()

    fun addMovie(movie: Movie) = repo.addMovie(movie)

    fun removeMovie(id: Int) = repo.removeMovie(id)

    fun getMovie(id: Int): Movie? = repo.getMovieById(id)
}
