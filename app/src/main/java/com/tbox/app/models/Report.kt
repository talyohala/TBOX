package com.tbox.app.models

data class Report(
    val date: String,
    val activeUsers: Int,
    val newComments: Int,
    val newMovies: Int
)
