package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import com.tbox.app.models.Statistics
import com.tbox.app.models.User
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

class StatisticsManager : ViewModel() {
    private val usersFile = File("data/users.json")
    private val viewsFile = File("data/views.json")
    private val moviesFile = File("data/movies.json")

    fun getStats(): Statistics {
        val users = if (usersFile.exists()) Json.decodeFromString<List<User>>(usersFile.readText()) else emptyList()
        val views = if (viewsFile.exists()) Json.decodeFromString<Map<String, Int>>(viewsFile.readText()) else emptyMap()
        val movies = if (moviesFile.exists()) Json.decodeFromString<Map<String, String>>(moviesFile.readText()) else emptyMap()

        val totalUsers = users.size
        val totalPremium = users.count { it.isPremium }
        val totalMovies = movies.size
        val totalViews = views.values.sum()
        val mostViewedMovie = views.maxByOrNull { it.value }?.key ?: "אין"
        val mostActiveUser = users.maxByOrNull { user ->
            views.filterKeys { it.startsWith(user.id) }.values.sum()
        }?.name ?: "אין"

        return Statistics(
            totalUsers = totalUsers,
            totalPremium = totalPremium,
            totalMovies = totalMovies,
            totalViews = totalViews,
            mostViewedMovie = mostViewedMovie,
            mostActiveUser = mostActiveUser
        )
    }
}
