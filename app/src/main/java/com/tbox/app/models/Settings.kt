package com.tbox.app.models

data class Settings(
    val enableComments: Boolean = true,
    val enableLive: Boolean = true,
    val allowSignup: Boolean = true
)
