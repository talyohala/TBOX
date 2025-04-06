package com.tboxe.repository

import com.tboxe.data.MovieDao
import com.tboxe.model.Movie

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun getAllMovies() = movieDao.getAllMovies()
    suspend fun getMovie(id: Int) = movieDao.getMovieById(id)
    suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)
    suspend fun deleteMovie(movie: Movie) = movieDao.deleteMovie(movie)
}
