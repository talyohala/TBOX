package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.User

@Composable
fun ManageUsersScreen(users: List<User>, onBlock: (User) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("ניהול משתמשים", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(users) { user ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("ID: ${user.id}")
                            Text("שם: ${user.name}")
                            Text("פרימיום: ${if (user.isPremium) "כן" else "לא"}")
                        }
                        Button(onClick = { onBlock(user) }) {
                            Text("חסום")
                        }
                    }
                }
            }
        }
    }
}
