package com.tboxe.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tboxe.viewmodel.AdminViewModel

@Composable
fun AdminDashboardScreen(navController: NavController, adminViewModel: AdminViewModel) {
    val isAdmin = adminViewModel.checkAdmin()

    if (!isAdmin) {
        Text(
            text = "אין לך הרשאה לגשת למסך זה",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("לוח ניהול") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                navController.navigate("add_movie")
            }) {
                Text("➕ הוסף סרט")
            }

            Button(onClick = {
                navController.navigate("movie_list")
            }) {
                Text("🎬 רשימת סרטים")
            }

            Button(onClick = {
                navController.navigate("user_list")
            }) {
                Text("👥 ניהול משתמשים")
            }

            Button(onClick = {
                navController.navigate("stats")
            }) {
                Text("📊 סטטיסטיקות")
            }
        }
    }
}
