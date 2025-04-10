package com.tbox.app.screens.admin.users.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.User

@Composable
fun UserItemView(
    user: User,
    onBlockToggle: () -> Unit,
    onPremiumToggle: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "שם: ${user.name}", style = MaterialTheme.typography.titleMedium)
            Text(text = "אימייל: ${user.email}")
            Text(text = "סטטוס: ${if (user.isBlocked) "חסום" else "פעיל"}")
            Text(text = "פרימיום: ${if (user.isPremium) "כן" else "לא"}")

            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = onBlockToggle) {
                    Text(if (user.isBlocked) "שחרר חסימה" else "חסום")
                }
                Spacer(modifier = Modifier.width(12.dp))
                Button(onClick = onPremiumToggle) {
                    Text(if (user.isPremium) "הסר פרימיום" else "הפוך לפרימיום")
                }
            }
        }
    }
}
