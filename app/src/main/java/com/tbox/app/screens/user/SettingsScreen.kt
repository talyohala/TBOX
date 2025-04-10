package com.tbox.app.screens.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.ui.components.AppTopBar

@Composable
fun SettingsScreen(navController: NavController, onLogout: () -> Unit) {
    Scaffold(
        topBar = {
            AppTopBar(title = "הגדרות") {
                navController.popBackStack()
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "חשבון", style = MaterialTheme.typography.titleMedium)
            Divider()

            Text(
                text = "התנתקות",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLogout() }
                    .padding(12.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
