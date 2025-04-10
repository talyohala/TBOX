package com.tbox.app.screens.admin.alerts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class AlertItem(val message: String, val type: AlertType)

enum class AlertType {
    WARNING, INFO, ACTION
}

@Composable
fun AdminAlertsScreen(
    alerts: List<AlertItem>,
    onResolve: (AlertItem) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("התראות מערכת", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        if (alerts.isEmpty()) {
            Text("אין כרגע התראות לטיפול.", style = MaterialTheme.typography.bodyMedium)
        } else {
            alerts.forEach { alert ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = alert.message,
                            style = MaterialTheme.typography.bodyLarge,
                            color = when (alert.type) {
                                AlertType.WARNING -> MaterialTheme.colorScheme.error
                                AlertType.INFO -> MaterialTheme.colorScheme.primary
                                AlertType.ACTION -> MaterialTheme.colorScheme.secondary
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { onResolve(alert) }) {
                            Text("סמן כטופל")
                        }
                    }
                }
            }
        }
    }
}
