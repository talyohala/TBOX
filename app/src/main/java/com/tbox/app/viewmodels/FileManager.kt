package com.tbox.app.viewmodels

import com.tbox.app.models.FileItem
import java.io.File

class FileManager {
    private val directory = File("uploads")

    init {
        if (!directory.exists()) directory.mkdirs()
    }

    fun listFiles(): List<FileItem> {
        return directory.listFiles()?.map {
            FileItem(name = it.name, path = it.absolutePath, type = it.extension)
        } ?: emptyList()
    }

    fun deleteFile(fileName: String): Boolean {
        val file = File(directory, fileName)
        return file.exists() && file.delete()
    }

    fun saveFile(name: String, content: ByteArray): Boolean {
        return try {
            File(directory, name).writeBytes(content)
            true
        } catch (e: Exception) {
            false
        }
    }
}
