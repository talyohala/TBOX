package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ContentManagerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ניהול תוכן", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { navController.navigate("add_movie") }) {
            Text("הוסף סרט")
        }

        Button(onClick = { navController.navigate("edit_movie") }) {
            Text("ערוך סרט")
        }

        Button(onClick = { navController.navigate("delete_movie") }) {
            Text("מחק סרט")
        }
    }
}
