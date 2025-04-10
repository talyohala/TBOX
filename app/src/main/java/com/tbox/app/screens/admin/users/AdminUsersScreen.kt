package com.tbox.app.screens.admin.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.User
import com.tbox.app.screens.admin.users.components.UserItemView

@Composable
fun AdminUsersScreen(
    users: List<User>,
    onUserSelected: (User) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "ניהול משתמשים", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(users.size) { index ->
                UserItemView(user = users[index], onClick = onUserSelected)
            }
        }
    }
}
