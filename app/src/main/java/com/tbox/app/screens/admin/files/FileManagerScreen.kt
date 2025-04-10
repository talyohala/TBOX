package com.tbox.app.screens.admin.files

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.viewmodels.FileManager

@Composable
fun FileManagerScreen() {
    val manager = remember { FileManager() }
    var files by remember { mutableStateOf(manager.listFiles()) }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("ניהול קבצים", style = MaterialTheme.typography.headlineSmall)

        LazyColumn(modifier = Modifier.fillMaxHeight().padding(top = 16.dp)) {
            items(files.size) { index ->
                val file = files[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (manager.deleteFile(file.name)) {
                                files = manager.listFiles()
                                message = "הקובץ נמחק בהצלחה"
                            } else {
                                message = "שגיאה במחיקת הקובץ"
                            }
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("שם קובץ: ${file.name}")
                        Text("סוג: ${file.type}")
                    }
                }
            }
        }

        if (message.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = message, color = MaterialTheme.colorScheme.primary)
        }
    }
}
