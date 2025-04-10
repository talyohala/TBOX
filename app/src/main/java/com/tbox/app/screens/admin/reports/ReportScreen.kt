package com.tbox.app.screens.admin.reports

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tbox.app.storage.ReportStorage
import com.tbox.app.viewmodels.ReportManager

@Composable
fun ReportScreen() {
    val context = LocalContext.current
    val manager = remember { ReportManager() }
    val storage = remember { ReportStorage(context) }
    val report = remember { manager.generateDailyReport().also { storage.saveReport(it) } }
    val previousDates = remember { storage.listAvailableReports().drop(1) } // exclude today's

    Column(modifier = Modifier.padding(24.dp)) {
        Text("דו\"ח יומי - ${report.date}", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("משתמשים פעילים היום: ${report.activeUsers}")
        Text("תגובות חדשות: ${report.newComments}")
        Text("סרטים שנוספו היום: ${report.newMovies}")
        Spacer(modifier = Modifier.height(24.dp))

        if (previousDates.isNotEmpty()) {
            Text("דו\"חות קודמים:", style = MaterialTheme.typography.titleMedium)
            previousDates.forEach { date ->
                Text("- $date")
            }
        }
    }
}
