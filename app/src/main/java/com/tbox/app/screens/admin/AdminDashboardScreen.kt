package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.navigation.Routes

@Composable
fun AdminDashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("לוח ניהול", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { navController.navigate(Routes.MANAGE_USERS) }, modifier = Modifier.fillMaxWidth()) {
            Text("ניהול משתמשים")
        }

        Button(onClick = { navController.navigate(Routes.MANAGE_MOVIES) }, modifier = Modifier.fillMaxWidth()) {
            Text("ניהול סרטים")
        }

        Button(onClick = { navController.navigate(Routes.BACKUPS) }, modifier = Modifier.fillMaxWidth()) {
            Text("גיבויים")
        }

        Button(onClick = { navController.navigate(Routes.REPORTS) }, modifier = Modifier.fillMaxWidth()) {
            Text("דו\"חות")
        }
    }
}
