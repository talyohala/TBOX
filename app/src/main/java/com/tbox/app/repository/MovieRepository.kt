package com.tbox.app.repository

import com.tbox.app.model.Movie

class MovieRepository {
    private val movies = mutableListOf<Movie>()

    fun getAllMovies(): List<Movie> = movies

    fun addMovie(movie: Movie) {
        movies.add(movie)
    }

    fun removeMovie(id: Int) {
        movies.removeAll { it.id == id }
    }

    fun getMovieById(id: Int): Movie? = movies.find { it.id == id }
}
