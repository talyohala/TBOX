package com.tbox.app.models

data class Movie(
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val genre: String,
    val rating: Float
)
