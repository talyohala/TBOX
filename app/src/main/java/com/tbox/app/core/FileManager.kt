package com.tbox.app.core

import android.content.Context
import java.io.File

class FileManager(private val context: Context) {

    private val filesDir = File(context.filesDir, "uploads")

    init {
        if (!filesDir.exists()) {
            filesDir.mkdirs()
        }
    }

    fun saveFile(fileName: String, content: ByteArray): Boolean {
        return try {
            val file = File(filesDir, fileName)
            file.writeBytes(content)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun deleteFile(fileName: String): Boolean {
        val file = File(filesDir, fileName)
        return file.exists() && file.delete()
    }

    fun listFiles(): List<String> {
        return filesDir.listFiles()?.map { it.name } ?: emptyList()
    }

    fun getFile(fileName: String): File? {
        val file = File(filesDir, fileName)
        return if (file.exists()) file else null
    }
}

