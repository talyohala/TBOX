package com.tbox.app.utils

import com.tbox.app.models.User

fun addPremium(user: User): User {
    return user.copy(isPremium = true)
}

fun removePremium(user: User): User {
    return user.copy(isPremium = false)
}
