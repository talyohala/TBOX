package com.tbox.app.screens.admin.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tbox.app.models.User
import com.tbox.app.screens.admin.users.components.UserItemView

@Composable
fun UserManagementScreen(
    users: List<User>,
    onBlockToggle: (User) -> Unit,
    onPremiumToggle: (User) -> Unit
) {
    LazyColumn {
        items(users.size) { index ->
            val user = users[index]
            UserItemView(
                user = user,
                onBlockToggle = { onBlockToggle(user) },
                onPremiumToggle = { onPremiumToggle(user) }
            )
        }
    }
}
