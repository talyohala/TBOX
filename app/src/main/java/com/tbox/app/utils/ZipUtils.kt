package com.tbox.app.utils

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object ZipUtils {

    fun zipFiles(files: List<File>, outputZip: File) {
        ZipOutputStream(BufferedOutputStream(FileOutputStream(outputZip))).use { zos ->
            files.forEach { file ->
                if (file.exists()) {
                    FileInputStream(file).use { fis ->
                        val entry = ZipEntry(file.name)
                        zos.putNextEntry(entry)
                        fis.copyTo(zos)
                        zos.closeEntry()
                    }
                }
            }
        }
    }
}
