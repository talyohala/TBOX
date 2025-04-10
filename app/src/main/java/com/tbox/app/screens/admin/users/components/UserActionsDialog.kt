package com.tbox.app.screens.admin.users.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.tbox.app.models.User

@Composable
fun UserActionsDialog(
    user: User,
    onDismiss: () -> Unit,
    onDelete: () -> Unit,
    onChangeRole: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        title = {
            Text("פעולות על ${user.name}")
        },
        text = {
            Column {
                TextButton(onClick = { onChangeRole("admin") }) {
                    Text("הפוך לאדמין")
                }
                TextButton(onClick = { onChangeRole("premium") }) {
                    Text("הפוך לפרימיום")
                }
                TextButton(onClick = { onChangeRole("user") }) {
                    Text("הפוך לרגיל")
                }
                TextButton(onClick = onDelete) {
                    Text("מחק משתמש", color = MaterialTheme.colorScheme.error)
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("סגור")
            }
        }
    )
}
