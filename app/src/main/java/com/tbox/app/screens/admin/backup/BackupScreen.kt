package com.tbox.app.screens.admin.backup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.viewmodels.BackupManager
import java.io.File

@Composable
fun BackupScreen() {
    val viewModel = remember { BackupManager() }
    var backups by remember { mutableStateOf(viewModel.getAllBackups()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            viewModel.createNewBackup()
            backups = viewModel.getAllBackups()
        }) {
            Text("צור גיבוי חדש")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("רשימת גיבויים:", style = MaterialTheme.typography.titleMedium)

        backups.forEach { file ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = file.name)
                Button(onClick = {
                    viewModel.deleteBackup(file)
                    backups = viewModel.getAllBackups()
                }) {
                    Text("מחק")
                }
            }
        }
    }
}

