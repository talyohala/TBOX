package com.tbox.app.screens.admin.premium

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.User

@Composable
fun PremiumManagementScreen(
    users: List<User>,
    onAddPremium: (User) -> Unit,
    onRemovePremium: (User) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("ניהול משתמשי פרימיום", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        users.filter { !it.isPremium }.forEach { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${user.name} (${user.email})")
                Button(onClick = { onAddPremium(user) }) {
                    Text("הפוך לפרימיום")
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 12.dp))

        users.filter { it.isPremium }.forEach { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${user.name} (${user.email})")
                Button(onClick = { onRemovePremium(user) }) {
                    Text("הסר פרימיום")
                }
            }
        }
    }
}
