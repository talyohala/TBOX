package com.tbox.app.models

data class Statistics(
    val totalUsers: Int,
    val totalPremium: Int,
    val totalMovies: Int,
    val totalViews: Int,
    val mostViewedMovie: String,
    val mostActiveUser: String
)
