package com.tbox.app.utils

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object BackupUtils {

    private val backupDir = File("backups").apply { mkdirs() }

    fun createBackup(filesToBackup: List<File>): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val backupFile = File(backupDir, "backup_$timestamp.zip")

        ZipUtils.zipFiles(filesToBackup, backupFile)
        return backupFile
    }

    fun listBackups(): List<File> {
        return backupDir.listFiles()?.sortedByDescending { it.lastModified() } ?: emptyList()
    }

    fun deleteBackup(file: File): Boolean {
        return file.exists() && file.delete()
    }
}
