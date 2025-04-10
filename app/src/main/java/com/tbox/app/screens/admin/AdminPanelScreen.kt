package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AdminPanelScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("פאנל ניהול ראשי")

        Button(onClick = { navController.navigate("admin_add_movie") }) {
            Text("הוסף סרט")
        }

        Button(onClick = { navController.navigate("admin_edit_movie") }) {
            Text("ערוך סרט")
        }

        Button(onClick = { navController.navigate("admin_delete_movie") }) {
            Text("מחק סרט")
        }

        Button(onClick = { /* navController.navigate("admin_premium") */ }) {
            Text("ניהול פרימיום")
        }

        Button(onClick = { /* navController.navigate("admin_backup") */ }) {
            Text("גיבויים")
        }

        Button(onClick = { /* navController.navigate("admin_reports") */ }) {
            Text("דו\"חות")
        }

        Button(onClick = { /* navController.navigate("admin_users") */ }) {
            Text("ניהול משתמשים")
        }
    }
}
