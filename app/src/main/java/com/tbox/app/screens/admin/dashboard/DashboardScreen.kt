package com.tbox.app.screens.admin.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.viewmodels.StatisticsManager

@Composable
fun DashboardScreen() {
    val statsManager = remember { StatisticsManager() }
    val stats = remember { statsManager.getStats() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("דשבורד ניהול", style = MaterialTheme.typography.headlineSmall)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("סה\"כ משתמשים: ${stats.totalUsers}")
                Text("משתמשי פרימיום: ${stats.totalPremium}")
                Text("כמות סרטים: ${stats.totalMovies}")
                Text("סה\"כ צפיות: ${stats.totalViews}")
                Text("הסרט הכי נצפה: ${stats.mostViewedMovie}")
                Text("המשתמש הכי פעיל: ${stats.mostActiveUser}")
            }
        }
    }
}
