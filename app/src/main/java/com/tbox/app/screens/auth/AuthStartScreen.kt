package com.tbox.app.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.navigation.Routes

@Composable
fun AuthStartScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ברוך הבא ל־TBOX", style = MaterialTheme.typography.headlineLarge)

        Button(onClick = { navController.navigate(Routes.LOGIN) }, modifier = Modifier.fillMaxWidth()) {
            Text("התחבר")
        }

        Button(onClick = { navController.navigate(Routes.REGISTER) }, modifier = Modifier.fillMaxWidth()) {
            Text("הרשמה")
        }
    }
}
