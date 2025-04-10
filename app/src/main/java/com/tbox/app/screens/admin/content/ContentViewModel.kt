package com.tbox.app.screens.admin.content

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.tbox.app.model.Movie

class ContentViewModel : ViewModel() {

    // רשימת הסרטים המנוהלת בזיכרון (לשדרוג עתידי לחיבור API / DB)
    var movieList = mutableStateListOf<Movie>()
        private set

    var selectedMovie: Movie? = null

    fun addMovie(movie: Movie) {
        movieList.add(movie)
    }

    fun deleteMovie(movie: Movie) {
        movieList.remove(movie)
    }

    fun updateMovie(updated: Movie) {
        val index = movieList.indexOfFirst { it.title == updated.title }
        if (index >= 0) {
            movieList[index] = updated
        }
    }

    fun selectMovie(movie: Movie?) {
        selectedMovie = movie
    }

    fun clearSelection() {
        selectedMovie = null
    }
}
