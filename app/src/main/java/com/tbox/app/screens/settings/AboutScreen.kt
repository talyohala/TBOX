package com.tbox.app.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("אודות האפליקציה", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text("TBOX היא אפליקציית סטרימינג מתקדמת לצפייה בסרטים וסדרות.")
        Spacer(modifier = Modifier.height(8.dp))
        Text("גרסה: 1.0.0")
        Spacer(modifier = Modifier.height(8.dp))
        Text("פיתוח: TBOX Team")
    }
}
