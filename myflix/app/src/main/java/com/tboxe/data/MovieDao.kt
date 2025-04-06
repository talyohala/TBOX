package com.tboxe.data

import androidx.room.*
import com.tboxe.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY addedAt DESC")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: Int): Movie?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}
