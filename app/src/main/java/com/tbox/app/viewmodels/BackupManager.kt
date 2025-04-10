package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import com.tbox.app.utils.BackupUtils
import java.io.File

class BackupManager : ViewModel() {

    fun getAllBackups(): List<File> {
        return BackupUtils.listBackups()
    }

    fun createNewBackup(): File {
        val files = listOf(
            File("data/users.json"),
            File("data/movies.json"),
            File("data/settings.json")
        )
        return BackupUtils.createBackup(files)
    }

    fun deleteBackup(file: File): Boolean {
        return BackupUtils.deleteBackup(file)
    }
}
