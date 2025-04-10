package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReportsScreen(reports: List<String>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("דו\"חות מערכת", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        reports.forEach {
            Text("- $it", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
