package com.tbox.app.screens.user

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.viewmodel.UserViewModel

@Composable
fun ProfileScreen(userViewModel: UserViewModel = viewModel()) {
    val user = userViewModel.currentUser

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        if (user != null) {
            Text("שם משתמש: ${user.username}")
            Text("מזהה משתמש: ${user.id}")
            Text("הרשאות: ${if (user.isAdmin) "מנהל" else "רגיל"}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { userViewModel.logout() }) {
                Text("התנתק")
            }
        } else {
            Text("אין משתמש מחובר")
        }
    }
}
