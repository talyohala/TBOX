package com.tbox.app.screens.admin.files

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun FileManagementScreen() {
    val context = LocalContext.current
    val filesDir = context.filesDir
    var allFiles by remember { mutableStateOf(listFilesSortedByDate(filesDir)) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("ניהול קבצים", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(allFiles) { file ->
                FileRow(file = file, onClick = {
                    openFile(context, File(filesDir, file))
                })
            }
        }
    }
}

@Composable
fun FileRow(file: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Text(text = file)
        }
    }
}

fun listFilesSortedByDate(directory: File): List<String> {
    val files = directory.listFiles()
    return files?.sortedByDescending { it.lastModified() }?.map { it.name } ?: emptyList()
}

fun openFile(context: Context, file: File) {
    val uri = Uri.fromFile(file)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "*/*")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
    }
    context.startActivity(intent)
}
